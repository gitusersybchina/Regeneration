package org.demo.lxx.algorithm.niuke;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * <p>
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述:
 * 输出合并后的键值对（多行）
 * <p>
 * 示例1
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/22 11:41
 */
public class HuaweiDemo09 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            final int key = sc.nextInt();
            final int value = sc.nextInt();
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        map.keySet().stream().sorted().forEach(key -> {
            System.out.println(key + " " +map.get(key));
        });
    }


}
