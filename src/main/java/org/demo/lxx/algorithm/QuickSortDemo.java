package org.demo.lxx.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序练习
 * 方法的基本思想是：
 * <p>
 * 1．先从数列中取出一个数作为基准数。
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/25 15:05
 */
public class QuickSortDemo {


    /**
     * 挖坑填数法
     * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
     * 2．j–由后向前找比基准数小的数，找到后挖出此数填前一个坑a[i]中。
     * 3．i++由前向后找比基准数大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     *
     * @param array      待排序数组
     * @param leftIndex  自左下标位置
     * @param rightIndex 自右下标位置
     */
    public static void quickSort(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            // ------------------ 挖坑取数部分 -------------------------
            int i = leftIndex, j = rightIndex;
            // 首次基准数字取了第一个元素
            int baseNumber = array[leftIndex];
            while (i < j) {
                // 从右向左找第一个小于基准数的元素
                while (i < j && array[j] >= baseNumber) {
                    j--;
                }
                // 从上面这个循环出来后如果i<j说明自右向左找到了第一个小于基准数的元素，
                // 此时取出它填充到a[i],同时下标i右移,缩小范围
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }
                // 从左向右找第一个大于等于基准数的元素
                while (i < j && array[i] < baseNumber) {
                    i++;
                }
                // 从上面这个循环出来后如果i<j说明自左向右找到了第一个大于等于基准数的元素，
                // 此时取出它填充到a[j],同时下标j左移,缩小范围
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            // 此时i==j,将基准数填入i位置
            array[i] = baseNumber;
            // ------------------ 递归部分(分治) -------------------------
            // 递归处理i左边的
            quickSort(array, leftIndex, i - 1);
            // 递归处理j右边的
            quickSort(array, j + 1, rightIndex);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final int size = scanner.hasNext() ? Integer.parseInt(scanner.next()) : 0;
            final int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("快速排序前输入参数为:" + Arrays.toString(array));
            quickSort(array, 0, size - 1);
            System.out.println("快速排序前输出结果为:" + Arrays.toString(array));
        }
    }

}
