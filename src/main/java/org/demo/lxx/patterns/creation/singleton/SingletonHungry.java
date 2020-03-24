package org.demo.lxx.patterns.creation.singleton;

/**
 * 单例模式-饿汉式
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2019/10/28 17:52
 */
public class SingletonHungry {

    private static SingletonHungry uniqueInstance = new SingletonHungry();

    private SingletonHungry() {
    }

    /**
     * 线程安全
     * 浪费资源
     */
    public static SingletonHungry getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonHungry();
        }
        return uniqueInstance;
    }
}
