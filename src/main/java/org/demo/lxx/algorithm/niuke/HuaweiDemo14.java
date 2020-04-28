package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * <p>
 * <p>
 * 接口说明
 * <p>
 * /**
 * * 反转句子
 * *
 * * @param sentence 原句子
 * * @return 反转后的句子
 * <p>
 * public String reverse(String sentence);
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 将一个英文语句以单词为单位逆序排放。
 * <p>
 * 输出描述:
 * 得到逆序的句子
 * <p>
 * 示例1
 * 输入
 * I am a boy
 * 输出
 * boy a am I
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/23 11:41
 */
public class HuaweiDemo14 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine();
        reverseWord(input);
    }

    static void reverseWord(String input) {

        final StringBuilder sb = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        System.out.print(sb.toString());
    }
}


