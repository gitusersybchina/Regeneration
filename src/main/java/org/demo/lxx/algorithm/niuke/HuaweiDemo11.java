package org.demo.lxx.algorithm.niuke;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 * <p>
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 * <p>
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 * <p>
 * 示例1
 * 输入
 * abc
 * 输出
 * 3
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/3/23 11:41
 */
public class HuaweiDemo11 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        countDistinctChar(input);
    }

    static void countDistinctChar(String input) {
        char[] charArray = input.toCharArray();
        Set<String> set = new HashSet<>();
        for (char item : charArray) {
            if (127 >= item) {
                set.add(String.valueOf(item));
            }
        }
        System.out.println(set.size());
    }
}


