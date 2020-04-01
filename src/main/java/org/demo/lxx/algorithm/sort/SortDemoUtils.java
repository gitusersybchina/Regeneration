package org.demo.lxx.algorithm.sort;

import javafx.util.Pair;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 排序用到的一些通用方法
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/31 14:35
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortDemoUtils {


    public static final int DEFAULT_BUCKET_QUANTITY = 5;

    public static final int DEFAULT_RADIX = 10;


    /**
     * 获取一个序列中的最小值和最大值
     *
     * @param array  序列
     * @param length 序列长度
     * @return 最大值和最小值 maxValue->minValue
     */
    public static Pair<Integer, Integer> getMaxAndMinValue(int[] array, int length) {
        int maxValue = array[0], minValue = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return new Pair<>(maxValue, minValue);
    }

    /**
     * 交换
     *
     * @param array 序列
     * @param m     m下标
     * @param n     n下标
     */
    public static void swap(int[] array, int m, int n) {

        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    /**
     * 获取数据的位数
     *
     * @param number 数字
     * @return 数据十进制位数
     */
    public static int getDigitsOfNumber(int number) {

        int digit = 0;
        while (number > 0) {
            digit++;
            number /= DEFAULT_RADIX;
        }
        return digit;
    }


}
