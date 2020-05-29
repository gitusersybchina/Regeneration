package org.liuxixi.demo.base.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 学习JUC.atomic包下的一些工具类
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/5/21 15:46
 */
public class JucAtomicDemos {


    public static void testAtomicLong() {

        List<Long> ids = new ArrayList<>();
        final AtomicLong atomicLong = new AtomicLong();
        for (int i = 0; i < 10; i++) {
            ids.add(atomicLong.incrementAndGet());
        }
        final String str = ids.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(str);
    }

    public static void main(String[] args) {
        testAtomicLong();
    }
}
