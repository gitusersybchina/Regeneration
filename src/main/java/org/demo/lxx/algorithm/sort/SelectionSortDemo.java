package org.demo.lxx.algorithm.sort;

/**
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * <p>
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果
 * <p>
 * 平均时间复杂度 O(n2) 空间复杂度 O(1) 具有不稳定性
 * <p>
 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。
 * 唯一的好处可能就是不占用额外的内存空间了吧。
 * 理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法。
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/27 14:26
 */
public class SelectionSortDemo {

    /**
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     * 使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     * @param array 待排序数组
     */
    public static void sampleSelectSort(int[] array) {

        final int length = array.length;
        int minIndex, temp;
        // 遍历无序数组
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            // 找到一个序列当中最小元素的下标
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换当前无序数组中的当前元素与最小元素
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

    }

}
