package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * <p>
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述:
 * 输出该数值的十进制字符串。
 * <p>
 * 示例1
 * 输入
 * 0xA
 * 输出
 * 10
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/19 11:41
 */
public class HuaweiDemo05 {


    public static void sixteenToTen(String input) {

        int count = 0;
        int temp = 0;
        int result = 0;
        input = input.substring(2);
        char[] chars = input.toCharArray();
        for (final char ch : chars) {
            if (ch >= '0' && ch <= '9') {
                temp = ch - '0';
            } else if (ch >= 'A' && ch <= 'Z') {
                temp = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'z') {
                temp = ch - 'a' + 10;
            } else {
                break;
            }
            result += temp * Math.pow(16, input.length() - count - 1);
            count++;
        }
        System.out.println(result);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            sixteenToTen(scanner.nextLine());
        }

    }


}
