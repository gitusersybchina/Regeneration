package org.demo.lxx.framework;

import java.util.Collection;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.ThreadUtils;

/**
 * Description for this class
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/4/14 15:49
 */
public class HuToolDemos {


    public static void main(String[] args) {

        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 20; i++) {
            threadLocal.set(RandomUtils.nextLong());
        }
        final Long aLong = threadLocal.get();
        System.out.println(aLong);

        final Collection<Thread> allThreads = ThreadUtils.getAllThreads();
        System.out.println(allThreads);

    }


}
