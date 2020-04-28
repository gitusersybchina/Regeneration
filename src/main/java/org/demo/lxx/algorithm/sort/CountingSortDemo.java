package org.demo.lxx.algorithm.sort;

import java.util.Arrays;

import org.apache.commons.lang3.tuple.Pair;


/**
 * 计数排序示例
 * <p>
 * 计数排序为非比较排序算法
 * 其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 额外数组中元素下标是待排序数组中元素的值，而额外数组中的值是其下标的值在待排序数组中作为元素的值出现的次数。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * <p>
 * 平均时间复杂度 O(n+k) 空间复杂度 O(k) 具有稳定性
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/3/30 18:19
 */
public class CountingSortDemo {


    /**
     * 计数排序实现步骤:
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组bucket的第i项；
     * 对所有的计数累加（从bucket中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第bucket(i)项，每放一个元素就将bucket(i)减去1。
     *
     * @param array 待排序数据
     */
    public static void countingSortByRange(int[] array) {

        final int length = array.length;
        if (length > 0) {
            // 获取到最大值和最小值
            // 通过流的方式在首次运行时会比较浪费时间，但初始化后可快速获取
            //  int maxValue = Arrays.stream(array).max().getAsInt();
            //  int minValue = Arrays.stream(array).min().getAsInt();

            Pair<Integer, Integer> maxAndMinValue = SortDemoUtils.getMaxAndMinValue(array, length);
            final int maxValue = maxAndMinValue.getKey(), minValue = maxAndMinValue.getValue();
            // 定义额外的空间用来计数待排序数据中的元素,长度为元素的范围,
            final int bucketLength = maxValue - minValue + 1;
            final int[] bucket = new int[bucketLength];
            // 初始bucket每个元素计数都为0
            Arrays.fill(bucket, 0);
            for (int value : array) {
                bucket[value - minValue]++;
            }
            int sortedIndex = 0;
            // 再将bucket中的下标按照元素（下标出现次数）反向填充到原数组中
            for (int i = 0; i < bucketLength; i++) {
                while (bucket[i] > 0) {
                    array[sortedIndex++] = i + minValue;
                    // 取出后计数相应减1
                    bucket[i]--;
                }
            }
        }
    }

    /**
     * 基于以上的实现
     * 每次都要找到一个范围，在计数和反向填充时由需要最小值参与运算
     * 可以调整为一开始定义额外空间时，长度直接为最大值+1，这样就不再需要最小值了
     *
     *
     * @param array 待排序数组
     */
    public static void countingSortByMaxValue(int[] array) {

        final int length = array.length;
        if (length > 0) {
            // 获取到最大值
            // 通过流的方式在首次运行时会比较浪费时间，但初始化后可快速获取
            // final int maxNumber = Arrays.stream(array).max().getAsInt();
            int maxNumber = array[0];
            for (int i = 1; i < length; i++) {
                if (array[i] > maxNumber) {
                    maxNumber = array[i];
                }
            }
            // 定义额外的空间用来计数待排序数据中的元素,长度为最大元素+1,
            final int bucketLength = maxNumber + 1;
            final int[] bucket = new int[bucketLength];
            // 初始bucket每个元素计数都为0
            Arrays.fill(bucket, 0);
            for (int value : array) {
                bucket[value]++;
            }
            int sortedIndex = 0;
            // 再将bucket中的下标按照元素（下标出现次数）反向填充到原数组中
            for (int i = 0; i < bucketLength; i++) {
                while (bucket[i] > 0) {
                    array[sortedIndex++] = i;
                    // 取出后计数相应减1
                    bucket[i]--;
                }
            }
        }
    }


}
