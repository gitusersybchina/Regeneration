package org.demo.lxx.algorithm.niuke;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/23 11:41
 */
public class HuaweiDemo15 {


    public static void main(String[] args) {

        sortWords();
    }

    static void sortWords() {
        Scanner sc = new Scanner(System.in);
        final int n = sc.hasNextLine() ? Integer.parseInt(sc.nextLine()) : 0;
        ArrayList<String> set = new ArrayList<>();
        for (int i = 1; i <= n && sc.hasNextLine(); i++) {
            set.add(sc.nextLine());
        }
        System.out.println(set);
        set.stream().sorted().forEach(System.out::println);
    }
}


