package org.demo.lxx.framework.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.jdk1.7中的HashMap
 * 1.1 扩容造成死循环分析过程
 * 1.2 扩容造成数据丢失分析过程
 * 2.jdk1.8中HashMap
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/4/17 9:19
 */
public class HashMapDemos {




    static class HashMapThread extends Thread {

        private AtomicInteger i = new AtomicInteger();
        private Map<String, Integer> map = new HashMap<>(2);

    }
}
