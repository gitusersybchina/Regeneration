package org.demo.lxx.algorithm.sort;



/**
 * 直接插入排序
 * <p>
 * 核心思想：
 * 将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
 * 因此，从上面的描述中我们可以发现，直接插入排序可以用两个循环完成：
 * 第一层循环：遍历待比较的所有数组元素
 * 第二层循环：将本轮选择的元素(selected)与已经排好序的元素(ordered)相比较。
 * 如果：selected > ordered，那么将二者交换
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/26 17:56
 */
public class StraightlyInsertSortDemo {

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

}
