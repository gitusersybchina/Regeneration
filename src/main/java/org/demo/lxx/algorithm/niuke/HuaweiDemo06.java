package org.demo.lxx.algorithm.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * <p>
 * 详细描述：
 * <p>
 * <p>
 * 函数接口说明：
 * <p>
 * public String getResult(long ulDataInput)
 * <p>
 * 输入参数：
 * <p>
 * long ulDataInput：输入的正整数
 * <p>
 * 返回值：
 * <p>
 * String
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入一个long型整数
 * <p>
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * <p>
 * 示例1
 * 输入
 * 180
 * 输出
 * 2 2 3 3 5
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/3/19 11:41
 */
public class HuaweiDemo06 {


    public static String getResult(long ulDataInput) {

        if (ulDataInput == 2) {
            return "2 ";
        }
        StringBuilder result = new StringBuilder();
        int index = 2;
        while (index <= ulDataInput) {
            if (ulDataInput % index == 0) {
                if (index == ulDataInput) {
                    result.append(index).append(" ");
                    break;
                }
                result.append(index).append(" ");
                ulDataInput = ulDataInput / index;
            } else {
                index++;
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(getResult(scanner.nextLong()));
        }
        scanner.close();
    }


}
