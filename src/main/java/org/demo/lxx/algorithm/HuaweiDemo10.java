package org.demo.lxx.algorithm;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * <p>
 * 输入描述:
 * 输入一个int型整数
 * <p>
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 示例1
 * 输入
 * 9876673
 * 输出
 * 37689
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/22 11:41
 */
public class HuaweiDemo10 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        reverseAndDistinctNumber(n);
    }

    static void reverseAndDistinctNumber(int n) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        final String str = String.valueOf(n);
        for (int i = str.length() - 1; i >= 0; i--) {
            String s = String.valueOf(str.charAt(i));
            set.add(Integer.parseInt(s));
        }
        set.forEach(System.out::print);
    }
}


