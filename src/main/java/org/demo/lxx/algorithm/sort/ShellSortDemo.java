package org.demo.lxx.algorithm.sort;


/**
 * 希尔排序简单实现
 * <p>
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * <p>
 * 主要思想是把一组数组分成了不同的“组”，只有同组元素才能比较和排序。
 * 随着排序的进行，“组”会慢慢减少，“组”中的元素也会慢慢增多，数组整体也会慢慢有序。
 * <p>
 * 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。
 * <p>
 * 平均时间复杂度 O(n*logN)  空间复杂度O(1)
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/27 15:05
 */
public class ShellSortDemo {


    /**
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * 1. 先对待排序数据进行分组
     * 2. 遍历所有的组
     *
     * @param arrays 待排序数据
     */
    public static void shellSort(int[] arrays) {

        final int length = arrays.length;
        // 初始化间隔增量为数组长度的一半,即数据被分为共 gap 组
        int currentNumber, gap = length / 2;
        // 只要间隔存在就继续排序
        while (gap > 0) {
            // 遍历每组进行插入排序
            for (int i = gap; i < length; i++) {
                currentNumber = arrays[i];
                // 根据间隔计算出从右向左第一个同组元素的位置
                int preIndex = i - gap;
                //  0 到 preIndex 之间“同组”的数组，从后往前遍历
                while (preIndex >= 0 && arrays[preIndex] > currentNumber) {
                    //
                    arrays[preIndex + gap] = arrays[preIndex];
                    // 继续向前遍历
                    preIndex -= gap;
                }
                arrays[preIndex + gap] = currentNumber;
            }
            // 缩小间隔增量
            gap /= 2;
        }
    }


}
