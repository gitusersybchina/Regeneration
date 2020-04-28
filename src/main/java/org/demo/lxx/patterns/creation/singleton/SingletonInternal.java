package org.demo.lxx.patterns.creation.singleton;

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
     * 延迟初始化、线程安全
     */
    private static class SingletonInternalHolder {
        private static final SingletonInternal INSTANCE = new SingletonInternal();
    }

    public static SingletonInternal getUniqueInstance() {
        return SingletonInternalHolder.INSTANCE;
    }
}
