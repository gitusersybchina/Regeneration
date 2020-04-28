package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 描述：
 * <p>
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * <p>
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * <p>
 * 输入描述:
 * 输入一个int整数
 * <p>
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 * <p>
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/3/23 11:41
 */
public class HuaweiDemo12 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int i = sc.nextInt();
        reverseNumber(i);
    }

    static void reverseNumber(int i) {
        final StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.reverse();
        System.out.println(sb.toString());
    }
}


