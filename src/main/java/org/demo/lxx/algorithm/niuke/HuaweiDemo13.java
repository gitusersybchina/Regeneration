package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述:
 * 输入N个字符
 * <p>
 * 输出描述:
 * 输出该字符串反转后的字符串
 * <p>
 * 示例1
 * 输入
 * abcd
 * 输出
 * dcba
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/23 11:41
 */
public class HuaweiDemo13 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine();
        reverseString(input);
    }

    static void reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        System.out.println(sb.toString());
    }
}


