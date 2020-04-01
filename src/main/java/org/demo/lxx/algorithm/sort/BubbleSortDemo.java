package org.demo.lxx.algorithm.sort;

/**
 * 冒泡排序示例
 * <p>
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * <p>
 * 时间复杂度为 O(n2) 空间复杂度 O(1) 具有稳定性
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/27 11:24
 */
public class BubbleSortDemo {

    /**
     * 冒泡排序实现
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     *
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {

        final int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                // 比较相邻元素交换
                if (array[j] > array[j + 1]) {
                    SortDemoUtils.swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 优化上面的算法同时采用降序排列
     * 用一个 flag 参数记录新一轮的排序中元素是否做过交换，
     * 如果没有，说明前面参与比较过的元素已经是正序，那就没必要再从头比较了
     * 通过这个变量可以得到最优时间复杂度  O(n)
     *
     * @param array 待排序数据
     */
    public static void bubbleSortOptimization(int[] array) {

        final int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - 1; j++) {
                // 比较相邻元素交换
                if (array[j] < array[j + 1]) {
                    SortDemoUtils.swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

}
