package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * <p>
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * <p>
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/19 11:41
 */
public class HuaweiDemo01 {


    public static int lastWordLengthByArray(String input) {

        input = input.trim();

        String[] wordsArray = input.split(" ");

        return wordsArray[wordsArray.length - 1].length();
    }

    public static int lastWordLength(String input) {

        input = input.trim();

        return input.length() - 1 - input.lastIndexOf(" ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            System.out.println(lastWordLength(next));
        }
    }


}
