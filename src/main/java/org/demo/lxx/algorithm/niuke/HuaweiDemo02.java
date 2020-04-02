package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/19 11:41
 */
public class HuaweiDemo02 {


    public static int countCharInStringByArray(char c, String input) {

        if (input.length() == 0) {
            return 0;
        }
        char[] chars = input.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (c == aChar) {
                count++;
            }
        }
        return count;
    }

    public static int countCharInString(char c, String input) {

        int length = input.length();
        if (length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (c == input.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        char c = scanner.nextLine().charAt(0);
        c = Character.toLowerCase(c);

        System.out.println(countCharInString(c, str));
    }


}
