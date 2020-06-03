package org.liuxixi.demo.base.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * 死锁示例
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/26 14:43
 */
@Slf4j
public class DeadLockDemos {


    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new DeadLockDemos().deadLock();
    }

    private void deadLock() {

        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    log.info("当前线程【{}】------------", Thread.currentThread().getName());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    log.info("当前线程【{}】------------", Thread.currentThread().getName());
                }
            }
        });

        t1.start();
        t2.start();
    }

}
