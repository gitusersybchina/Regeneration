package com.liaoxuefeng.demo.threads;


/**
 * Description for this class
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/29 17:04
 */
public class ThreadsCreateDemos {

    /**
     * 介绍线程的两种创建方式
     */
    public static class Main1 {

        public static void main(String[] args) {
            testCreateThreads();
        }

        public static void testCreateThreads() {
            Thread t = new MyThread();
            t.start(); // 启动新线程

            t = new Thread(new MyRunnable());
            t.start(); // 启动新线程

            t = new Thread(() -> {
                System.out.println("start new thread by lmaba!");
            });
            t.start(); // 启动新线程

            t = new MyHelloThread();
            // fixme 特别注意直接调用 run方法无效,相当于调用了一个普通方法
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.run();
            t.start();
        }

        static class MyHelloThread extends Thread {

            @Override
            public void run() {
                System.out.println("hello");
            }
        }

        static class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("start new thread by thread!");
            }
        }

        static class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("start new thread by runnable!");
            }
        }
    }

    /**
     * t线程开始运行以后，两个线程就开始同时运行了，并且由操作系统调度，程序本身无法确定线程的调度顺序
     */
    public static class Main2 {
        public static void main(String[] args) {
            System.out.println("main start...");
            Thread t = new Thread(() -> {
                System.out.println("thread run...");
                System.out.println("thread end.");
            });
            t.start();
            System.out.println("main end...");
        }
    }

    /**
     * 模拟多线程
     */
    public static class Main3 {
        public static void main(String[] args) {
            System.out.println("main start...");
            Thread t = new Thread(() -> {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
                System.out.println("thread end.");
            });
            t.start();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ignored) {
            }
            System.out.println("main end...");
        }
    }


}
