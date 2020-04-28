package org.demo.lxx.algorithm;


import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;


/**
 * 斐波那契数列相关示例
 * <p>
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/4/2 16:07
 */
@Slf4j
public class FibonacciDemos {

    /**
     * 获取第N个斐波那契数
     * <p>
     * 时间复杂度：O（N2），空间复杂度：O（N）
     *
     * @param n N
     * @return 第N个斐波那契数
     */
    public static long getFibonacciNumber(int n) {

        return n < 2 ? n : getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }

    /**
     * 得到一个长度为N的斐波那契数列
     *
     * @param n N
     * @return 长度为N的斐波那契数列
     */
    public static List<Long> getFibonacciArray(int n) {

        final List<Long> fibonacciArray = new ArrayList<>();
        long a = 1, b = 1;
        fibonacciArray.add(a);
        fibonacciArray.add(b);
        for (int i = 3; i < n; i++) {
            long temp = a + b;
            fibonacciArray.add(temp);
            a = b;
            b = temp;
        }
        return fibonacciArray;
    }


    public static void main(String[] args) {

        final int n = 10;
        List<Long> fibonacciArray = getFibonacciArray(n);
        if (log.isDebugEnabled()) {
            log.debug("长度为:[{}]的斐波那契数列:[{}]", n, fibonacciArray);
        }
    }
}
