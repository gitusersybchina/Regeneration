package org.demo.lxx.algorithm.sort;

import java.util.Arrays;

import javafx.util.Pair;

/**
 * 桶排序示例
 * <p>
 * 桶排序是计数排序的升级版。
 * 它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序 (Bucket sort)的工作的原理：
 * 假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 * <p>
 * 平均时间复杂度 O(n+k) 空间复杂度 O(n+k)  具有稳定性
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/30 18:11
 */
public class BucketSortDemo {


    /**
     * 桶排序
     * 1. 设置固定数量的空桶；
     * 2. 把数据放在对应的桶内；
     * 3. 分别对每个非空桶内数据进行排序；
     * 4. 拼接非空的桶内数据，得到最终的结果。
     *
     * @param bucketQuantity 桶的数量
     * @param array          待排序数据
     */
    public static void bucketSort(int[] array, int bucketQuantity) {

        final int length = array.length;
        if (array.length > 0) {

            Pair<Integer, Integer> maxAndMinValue = SortDemoUtils.getMaxAndMinValue(array, length);
            final int maxValue = maxAndMinValue.getKey(), minValue = maxAndMinValue.getValue();
            // 每个桶存放数据的范围
            final int range = (maxValue - minValue + 1) / bucketQuantity + 1;
            // 定义桶对应的二维数组,每个桶里存放了一个数据范围为range的数组,每个桶内最多有length个数据
            final int[][] buckets = new int[bucketQuantity][length];
            // 定义每个桶的存放元素的计数器
            final int[] everyBucketCount = new int[bucketQuantity];
            for (int value : array) {
                // 原待排数组中的元素应该在第几个桶里,桶的下标从0开始
                int k = (value - minValue) / range;
                // 放进桶里
                buckets[k][everyBucketCount[k]] = value;
                // 同时给每个桶计数
                everyBucketCount[k]++;
            }

            int i, j, arrayIndex = 0;
            for (i = 0; i < bucketQuantity; i++) {
                // 当前桶中实际元素数量
                final int currentBucketCount = everyBucketCount[i];
                if (currentBucketCount == 0) {
                    continue;
                }
                // 遍历每个桶,对其中的非空桶进行插入排序
                final int[] currentBucket = buckets[i];
                InsertionSortDemo.straightlyInsertSort(currentBucket);
                // 遍历当前桶中的元素,取出非空桶中的元素反向拼接到原待排序数组
                for (j = 0; j < currentBucketCount; j++) {
                    array[arrayIndex++] = currentBucket[currentBucket.length - currentBucketCount + j];
                    System.out.println(Arrays.toString(array));
                }
            }
        }

    }


}
