package org.demo.lxx.patterns.creation.singleton;

/**
 * 单例模式-懒汉式
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2019/10/28 17:52
 */
public class SingletonLazy {


    private static SingletonLazy uniqueInstance;

    private SingletonLazy() {
    }

    /**
     * 延迟实例化，节约资源
     * 线程不安全
     */
    public static SingletonLazy getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazy();
        }
        return uniqueInstance;
    }

    /**
     * 线程阻塞
     */
    public static synchronized SingletonLazy getUniqueInstanceSynchronized() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazy();
        }
        return uniqueInstance;
    }

    /**
     * 双重锁校验 线程安全
     */
    public static SingletonLazy getUniqueInstanceSynchronized2() {
        if (uniqueInstance == null) {
            synchronized (SingletonLazy.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonLazy();
                }
            }
        }
        return uniqueInstance;
    }
}
