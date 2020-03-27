package org.demo.lxx.algorithm.sort;


/**
 * 直接插入排序
 * <p>
 * 核心思想：
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/26 17:56
 */
public class InsertionSortDemo {

    /**
     * 交换式插入排序
     * <p>
     * 将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
     * 因此，从上面的描述中我们可以发现，直接插入排序可以用两个循环完成：
     * 第一层循环：遍历待比较的所有数组元素
     * 第二层循环：将本轮选择的元素(selected)与已经排好序的元素(ordered)相比较。
     * 如果：selected > ordered，那么将二者交换
     *
     * @param array 待排序数组
     */
    public static void straightlyInsertSort(int[] array) {

        final int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 前后指针插入排序法
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     *
     * @param array 待排序数据
     */
    public static void preIndexInsertSort(int[] array) {

        final int length = array.length;
        int currentNumber, preIndex;
        for (int i = 0; i < length; i++) {
            preIndex = i - 1;
            currentNumber = array[i];
            while (preIndex >= 0 && array[preIndex] > currentNumber) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = currentNumber;
        }
    }

}
