package org.liuxixi.demo.base.jmm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Java的四种引用
 * <p>
 * 强引用: 使用最多的引用方式，OOM时不会被回收
 * 软引用: 在程序内存不足时会被JVM回收
 * 弱引用: 当不再需要这个引用，JVM就会自动回收    {@link  java.util.WeakHashMap}
 * 虚引用: 虚引用与弱引用差不多，但是在被JVM回收前会放入{@link java.lang.ref.ReferenceQueue},
 * 其他引用都是被JVM回收后才放入引用队列，因此虚引用大多被使用在引用销毁之前的处理工作
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/4/16 16:21
 * @see java.lang.ref.Reference
 */
public class JavaReferenceDemos {

    /*
     * 以下四种引用都是针对被Reference子类包装的String
     */
    static {
        String strongRef = new String("strongReference");

        String softRef = new String("softReference");
        SoftReference<String> packageSoftRef = new SoftReference<>(softRef);

        String weakRef = new String("weakReference");
        WeakReference<String> packageWeakRef = new WeakReference<>(weakRef);

        String phantomRef = new String("phantomReference");
        PhantomReference<String> packagePhantomRef = new PhantomReference<>(phantomRef, new ReferenceQueue<>());
    }

}
