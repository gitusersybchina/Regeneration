package org.liuxixi.demo.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * 输出到长度为8的新字符串数组
 * <p>
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/19 11:41
 */
public class HuaweiDemo04 {


    public static void subString(String input) {

        while (input.length() >= 8) {
            System.out.println(input.substring(0, 8));
            input = input.substring(8);
        }
        if (input.length() > 0) {
            input = input + "00000000";
            System.out.println(input.substring(0, 8));
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            subString(scanner.nextLine());
        }

    }


}
