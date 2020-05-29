package org.liuxixi.demo.patterns.creation.singleton;

/**
 * 单例模式-内部类实现
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2019/10/31 15:54
 */
public class SingletonInternal {

    private SingletonInternal() {
    }

    /**
     * 内部类（登记式）
     * 延迟初始化、线程安全
     * 相对于DCL实现容易且能达到DCL一样的功效
     * 适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用
     */
    private static class SingletonInternalHolder {
        private static final SingletonInternal INSTANCE = new SingletonInternal();
    }

    public static SingletonInternal getUniqueInstance() {
        return SingletonInternalHolder.INSTANCE;
    }
}
