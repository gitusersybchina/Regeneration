package org.liuxixi.demo.base.threads;

import java.util.concurrent.atomic.AtomicBoolean;

import lombok.extern.slf4j.Slf4j;

/**
 * CAS（Compare and swap）比较和替换是设计并发算法时用到的一种技术。
 * <p>
 * 简单来说，比较和替换是使用一个期望值和一个变量的当前值进行比较
 * 如果当前变量的值与我们期望的值相等，就使用一个新值替换当前变量的值。
 * 在程序和算法中一个经常出现的模式就是“check and act”模式。
 * 先检查后操作模式发生在代码中首先检查一个变量的值，然后再基于这个值做一些操作。
 * 为了在一个多线程程序中良好的工作，”check then act” 操作必须是原子的。
 * 原子就是说”check“操作和”act“被当做一个原子代码块执行，不存在多个线程同时执行原子块。
 * 下面的lock()方法就是CAS的简单的示例：
 * </p>
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/25 17:18
 */
@Slf4j
public class CasLockDemos {


    interface MyLock {

        /**
         * CAS 锁
         *
         * @return 更新后的状态
         */
        boolean lock();

        /**
         * 挂起线程并进行CAS lock操作
         *
         * @param myLock @see CasLockDemos
         * @param <T>    extends MyLock
         * @param <U>    extends MyLock
         */
        default <T, U extends MyLock> void sleepAndLock(MyLock myLock) {

            log.debug("-----------------------线程【{}】挂起分割线------------------------", Thread.currentThread());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("-----------------------线程【{}】唤醒分割线------------------------", Thread.currentThread());
            final boolean lock = myLock.lock();
            log.info("线程【{}】对【{}】进行CAS操作后返回的lock状态为【{}】", Thread.currentThread(),
                    myLock.getClass().getSimpleName(), lock);
            log.debug("-----------------------线程【{}】挂起分割线------------------------", Thread.currentThread());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("-----------------------线程【{}】唤醒分割线------------------------", Thread.currentThread());
        }
    }

    /**
     * 线程不安全
     * 如果多个线程访问同一个MyLock1实例，lock()将不能保证正常工作。
     * 如果一个线程A检查locked的值，然后将其设置为false，与此同时，一个线程B也在检查locked的值，
     * 又或者，在线程A将locked的值设为false之前线程B也在检查locked值。
     * 因此，线程A和线程B可能都看到locked的值为false，然后两者都基于这个信息做一些操作。
     */
    static class MyLock1 implements Runnable, MyLock {

        private boolean locked = false;

        @Override
        public boolean lock() {
            // log.info("MyLock1 线程不安全的lock修改前{}", locked);
            if (!locked) {
                locked = true;
                // log.info("MyLock1 线程不安全的lock修改");
                return true;
            }
            return false;
        }

        @Override
        public void run() {
            log.debug("-----------------------线程【{}】挂起分割线-----------------------", Thread.currentThread());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("-----------------------线程【{}】唤醒分割线------------------------", Thread.currentThread());
            final MyLock1 myLock = new MyLock1();
            log.info("线程【{}】对MyLock1进行CAS操作前lock状态为【{}】", Thread.currentThread(), myLock.locked);
            sleepAndLock(myLock);
            myLock.lock();
            log.info("线程【{}】对MyLock1进行CAS操作后lock状态为【{}】", Thread.currentThread(), myLock.locked);
        }
    }

    /**
     * lock()方法是同步的,在某一时刻只能有一个线程在同一个MyLock实例上执行它
     * 通过 synchronized 同步锁就可以保障CPU内部执行原子的CAS操作
     */
    static class MyLock2 implements Runnable, MyLock {

        private boolean locked = false;

        @Override
        public synchronized boolean lock() {
            // log.info("MyLock2 线程安全的lock修改前{}", locked);
            if (!locked) {
                locked = true;
                // log.info("MyLock2 线程安全的lock修改");
                return true;
            }
            return false;
        }

        @Override
        public void run() {
            log.debug("-----------------------线程【{}】挂起分割线-----------------------", Thread.currentThread());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("-----------------------线程【{}】唤醒分割线------------------------", Thread.currentThread());
            final MyLock2 myLock = new MyLock2();
            log.info("线程【{}】对MyLock2进行CAS操作前lock状态为【{}】", Thread.currentThread(), myLock.locked);
            sleepAndLock(myLock);
            log.info("线程【{}】对MyLock2进行CAS操作后lock状态为【{}】", Thread.currentThread(), myLock.locked);
        }
    }

    /**
     * JDK5以来，可以使用java.util.concurrent.atomic包中的一些原子类来使用CPU中的这些功能
     * 使用Java5+提供的CAS特性而不是使用自己实现的的好处
     * Java5+中内置的CAS特性可以充分利用底层程序所运行机器的CPU的CAS特性,这会使CAS的代码运行更快
     */
    static class MyLock3 implements Runnable, MyLock {

        private AtomicBoolean locked = new AtomicBoolean(false);

        @Override
        public synchronized boolean lock() {
            // log.info("MyLock3 原子的lock修改前{}", locked);
            return locked.compareAndSet(false, true);
        }

        @Override
        public void run() {
            log.debug("-----------------------线程【{}】挂起分割线------------------------", Thread.currentThread());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("-----------------------线程【{}】唤醒分割线------------------------", Thread.currentThread());
            final MyLock3 myLock = new MyLock3();
            log.info("线程【{}】对MyLock3进行CAS操作前lock状态为【{}】", Thread.currentThread(), myLock.locked);
            sleepAndLock(myLock);
            log.info("线程【{}】对MyLock3进行CAS操作后lock状态为【{}】", Thread.currentThread(), myLock.locked);
        }
    }


    public static void main(String[] args) {
        final CasLockDemos casLockDemos = new CasLockDemos();

        casLockDemos.testMyLock1();
        // casLockDemos.testMyLock2();
        // casLockDemos.testMyLock3();
    }


    private void testMyLock1() {

        final MyLock1 myLock1 = new MyLock1();
        final Thread lock1Thread1 = new Thread(myLock1, "myLock1----thread----1");
        final Thread lock1Thread2 = new Thread(myLock1, "myLock1----thread----2");
        final Thread lock1Thread3 = new Thread(myLock1, "myLock1----thread----3");
        lock1Thread1.start();
        lock1Thread2.start();
        lock1Thread3.start();
    }

    private void testMyLock2() {
        final MyLock2 myLock2 = new MyLock2();
        final Thread lock2Thread1 = new Thread(myLock2, "myLock2----thread----1");
        final Thread lock2Thread2 = new Thread(myLock2, "myLock2----thread----2");
        final Thread lock2Thread3 = new Thread(myLock2, "myLock2----thread----3");
        lock2Thread1.start();
        lock2Thread2.start();
        lock2Thread3.start();
    }

    private void testMyLock3() {
        final MyLock3 myLock3 = new MyLock3();
        final Thread lock3Thread1 = new Thread(myLock3, "myLock3----thread----1");
        final Thread lock3Thread2 = new Thread(myLock3, "myLock3----thread----2");
        final Thread lock3Thread3 = new Thread(myLock3, "myLock3----thread----3");
        lock3Thread1.start();
        lock3Thread2.start();
        lock3Thread3.start();
    }

}
