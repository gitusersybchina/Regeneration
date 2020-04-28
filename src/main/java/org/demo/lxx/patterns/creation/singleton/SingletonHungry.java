package org.demo.lxx.patterns.creation.singleton;


/**
 * 单例模式-饿汉式
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2019/10/28 17:52
 */
public class SingletonHungry {

    private static SingletonHungry uniqueInstance = new SingletonHungry();

    private SingletonHungry() {
    }

    /**
     * 线程安全
     * 实现容易
     * 浪费资源
     * 比较常用，但容易产生垃圾对象
     */
    public static SingletonHungry getUniqueInstance() {
        return uniqueInstance;
    }
}
