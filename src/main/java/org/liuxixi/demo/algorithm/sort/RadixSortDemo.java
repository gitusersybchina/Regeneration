package org.liuxixi.demo.algorithm.sort;

import org.apache.commons.lang3.tuple.Pair;

/**
 * 基数排序示例
 * <p>
 * 基数排序是非比较排序。
 * 主要思想是对数组中所有元素先根据其个位进行排序，再根据其十位进行排序，之后是百位、千位，以此类推，直到最高位。
 * <p>
 * 平均时间复杂度 O(n*k)  空间复杂度 O(n+k) 具有稳定性
 * 其性能比桶排序略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/4/1 10:53
 */
public class RadixSortDemo {


    /**
     * 基数排序算法描述：
     * 取得数组中的最大数，并取得位数；
     * arr为原始数组，从最低位开始取每个位组成radix数组；
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     *
     * @param array 待排序数组
     */
    public static void radixSort(int[] array) {

        final int length = array.length;
        if (length > 0) {
            final int radix = SortDemoUtils.DEFAULT_RADIX;
            Pair<Integer, Integer> maxAndMinValue = SortDemoUtils.getMaxAndMinValue(array, length);
            int maxValue = maxAndMinValue.getKey(), minValue = maxAndMinValue.getValue();
            // 假如序列中有负数,所有数加上一个常数,使序列中所有值变成正数,这里常数为最小值的相反数
            if (minValue < 0) {
                for (int i = 0; i < length; i++) {
                    array[i] -= minValue;
                }
                maxValue -= minValue;
            }
            // 获取最大值位数
            final int maxValueDigits = SortDemoUtils.getDigitsOfNumber(maxValue);
            // 定义存放基数维度的桶,每个基数位可能存放length个元素
            final int[][] buckets = new int[radix][length];
            // 桶计数器
            final int[] everyBucketsCount = new int[radix];
            // 遍历最大数的位数,依次得到个十百千..位的数字
            for (int i = 0; i < maxValueDigits; i++) {
                // 遍历原数组得到当前位的数据放在桶里
                for (int value : array) {
                    // 获取当前位的模
                    int currentDigitMod = (int) Math.pow(radix, i + 1);
                    // 当前位的数字
                    int currentDigitValue = value % currentDigitMod;
                    // 放在第几个桶
                    int key = currentDigitValue / (int) Math.pow(radix, i);
                    // 放在桶里并计数
                    buckets[key][everyBucketsCount[key]++] = value;
                }
                // 回写数据
                int arrayIndex = 0;
                // 遍历所有的桶
                for (int j = 0; j < radix; j++) {
                    // 根据计数器中数据的个数依次取出对应桶中数据回写到原数组
                    final int currentBucketCount = everyBucketsCount[j];
                    for (int count = 0; count < currentBucketCount; count++) {
                        array[arrayIndex++] = buckets[j][count];
                        // 还原桶状态
                        buckets[j][count] = 0;
                    }
                    // 取完当前桶后将计数器还原
                    everyBucketsCount[j] = 0;
                }
            }
            // 假如序列中有负数,需要将之前加上的常数再减去还原成原数据
            if (maxValue < 0) {
                for (int i = 0; i < length; i++) {
                    array[i] += minValue;
                }
            }
        }

    }

}
