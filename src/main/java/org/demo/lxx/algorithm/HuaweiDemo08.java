package org.demo.lxx.algorithm;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * <p>
 * 输入描述:
 * 输入一个正浮点数值
 * <p>
 * 输出描述:
 * 输出该数值的近似整数值
 * <p>
 * 示例1
 * 输入
 * 5.5
 * 输出
 * 6
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/22 11:41
 */
public class HuaweiDemo08 {


    public static void floatToInt(float input) {
        String string = String.valueOf(input);
        int zhengshu = Integer.parseInt(string.substring(0, string.indexOf(".")));
        int xiaoshu = Integer.parseInt(string.substring(string.indexOf(".") + 1, string.indexOf(".") + 2));
        if (xiaoshu >= 5) {
            System.out.println(zhengshu + 1);
        } else {
            System.out.println(zhengshu);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float input = sc.nextFloat();
        floatToInt(input);
    }


}
