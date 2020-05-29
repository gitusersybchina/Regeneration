package org.liuxixi.demo.patterns.creation.singleton;

/**
 * 单例模式-懒汉式
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2019/10/28 17:52
 */
public class SingletonLazy {

    private static SingletonLazy uniqueInstance;

    private SingletonLazy() {
    }

    /**
     * 懒汉1
     * 延迟实例化，节约资源
     * 线程不安全
     * 实现容易，但因为多线程不安全，不能算是严格意义上的单例
     */
    public static SingletonLazy getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazy();
        }
        return uniqueInstance;
    }

    /**
     * 懒汉2
     * 优化懒汉1，为其增加 synchronized 线程同步锁
     * 线程阻塞
     * 实现容易，但是效率较低，适用于getUniqueInstance() 不频繁调用
     */
    public static synchronized SingletonLazy getUniqueInstanceSynchronized() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazy();
        }
        return uniqueInstance;
    }

    /**
     * 懒汉3
     * JDK5之后采用双锁机制 优化懒汉2
     * 双重锁校验 DCL (double-checked-locking)
     * 线程安全且能保持性能
     * 实现复杂
     */
    public static SingletonLazy getUniqueInstanceDcl() {
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
