package org.demo.lxx.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序示例
 * <p>
 * 归并排序是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * 平均时间复杂度 O(n*log2n) 空间复杂度 O(n) 具有稳定性
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/30 11:23
 */
public class MergeSortDemo {


    /**
     * 归并排序
     * <p>
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param array 待排序数组
     */
    public static void mergeSort(int[] array) {

        final int length = array.length;
        final int midIndex = length / 2;

        if (midIndex > 0) {

            final int[] left = Arrays.copyOfRange(array, 0, midIndex);
            final int[] right = Arrays.copyOfRange(array, midIndex, length);

            mergeSort(left);
            mergeSort(right);

            partyMergeSort(array, left, right);
        }
    }

    /**
     * @param array 原序列
     * @param left  左子序列
     * @param right 右子序列
     */
    private static void partyMergeSort(int[] array, int[] left, int[] right) {

        final int leftLength = left.length;
        final int rightLength = right.length;
        // 三根指针分别操作三个空间
        int originIndex = 0, leftIndex = 0, rightIndex = 0;
        // 从两个序列中选出最小值依次插入原空间
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] >= right[rightIndex]) {
                array[originIndex++] = right[rightIndex++];
            } else {
                array[originIndex++] = left[leftIndex++];
            }
        }
        // 合并左子序列到原序列
        while (leftIndex < leftLength) {
            array[originIndex++] = left[leftIndex++];
        }
        // 合并右子序列到原序列
        while (rightIndex < rightLength) {
            array[originIndex++] = right[rightIndex++];
        }
    }

}
