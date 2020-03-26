package org.demo.lxx.algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

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
     * 非递归的方式，采用栈来实现排序
     * 浪费空间换取时间
     *
     * @param array      待排序数组
     * @param leftIndex  自左下标位置
     * @param rightIndex 自右下标位置
     */
    public static void quickSortNotRecursive(int[] array, int leftIndex, int rightIndex) {

        Stack<Integer> stack = new Stack<>();
        stack.push(leftIndex);
        stack.push(rightIndex);
        // 栈不为空
        while (!stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            int baseIndex = partQuickSortByPit(array, left, right);
            // 左子序列
            if ((baseIndex - 1) > left) {
                stack.push(left);
                stack.push(baseIndex - 1);
            }
            // 右子序列
            if ((baseIndex + 1) < right) {
                stack.push(baseIndex + 1);
                stack.push(right);
            }
        }
    }


    /**
     * 递归使用挖坑填数法
     *
     * @param array      待排序数组
     * @param leftIndex  自左下标位置
     * @param rightIndex 自右下标位置
     */
    public static void quickSortByPit(int[] array, int leftIndex, int rightIndex) {

        // 递归终止条件
        if (leftIndex < rightIndex) {
            int baseIndex = partQuickSortByPit(array, leftIndex, rightIndex);
            // ------------------ 递归部分(分治) -------------------------
            // 递归处理基准数左边的
            quickSortByPit(array, leftIndex, baseIndex - 1);
            // 递归处理基准数右边的
            quickSortByPit(array, baseIndex + 1, rightIndex);
        }

    }

    /**
     * 递归使用左右指针交换法
     *
     * @param array      待排序数组
     * @param leftIndex  自左下标位置
     * @param rightIndex 自右下标位置
     */
    public static void quickSortByPointSwap(int[] array, int leftIndex, int rightIndex) {

        // 递归终止条件
        if (leftIndex < rightIndex) {
            int baseIndex = partQuickSortByPointSwap(array, leftIndex, rightIndex);
            // ------------------ 递归部分(分治) -------------------------
            // 递归处理基准数左边的
            quickSortByPointSwap(array, leftIndex, baseIndex - 1);
            // 递归处理基准数右边的
            quickSortByPointSwap(array, baseIndex + 1, rightIndex);
        }

    }

    /**
     * 递归使用前后指针交换法
     *
     * @param array      待排序数组
     * @param leftIndex  自左下标位置
     * @param rightIndex 自右下标位置
     */
    public static void quickSortByPrePointSwap(int[] array, int leftIndex, int rightIndex) {

        // 递归终止条件
        if (leftIndex < rightIndex) {
            int baseIndex = partQuickSortByPrePointSwap(array, leftIndex, rightIndex);
            // ------------------ 递归部分(分治) -------------------------
            // 递归处理基准数左边的
            quickSortByPrePointSwap(array, leftIndex, baseIndex - 1);
            // 递归处理基准数右边的
            quickSortByPrePointSwap(array, baseIndex + 1, rightIndex);
        }

    }

    /**
     * 一次快排的过程
     * 挖坑填数法
     * <p>
     * 1.取一个关键字(baseNumber)作为枢轴，一般取整组记录的第一个数/最后一个，这里采用选取序列第一个数为枢轴，也是初始的坑位。
     * 2.设置两个变量left = 待排序数组起始下标，right=待排序数组尾部下标
     * 3.从 left 一直向右走，直到找到一个大于key的值，然后将该数放入坑中，坑位变成了array[left]。
     * 4.从 right一直向左走，直到找到一个小于key的值，然后将该数放入坑中，坑位变成了array[right]。
     * 5.重复3和4的步骤，直到left和right相遇，然后将baseNumber放入最后一个坑位。
     *
     * @param array      待排序数组
     * @param leftIndex  自左下标位置
     * @param rightIndex 自右下标位置
     * @return leftIndex ==rightIndex 的位置 基准数字的新位置
     */
    private static int partQuickSortByPit(int[] array, int leftIndex, int rightIndex) {
        // ------------------ 挖坑取数部分 -------------------------
        // 首次基准数字取了第一个元素
//        int baseNumber = array[leftIndex];
        // 优化后基准数字取数组首中尾三数的中间数字
        int baseNumber = array[getBasIndexByMid(array, leftIndex, rightIndex)];
        while (leftIndex < rightIndex) {
            // 从右向左找第一个小于基准数的元素
            while (leftIndex < rightIndex && array[rightIndex] >= baseNumber) {
                rightIndex--;
            }
            // 从上面这个循环出来后如果leftIndex<rightIndex说明自右向左找到了第一个小于基准数的元素，
            // 此时取出它填充到a[leftIndex],同时下标leftIndex右移,缩小范围
            if (leftIndex < rightIndex) {
                array[leftIndex] = array[rightIndex];
                leftIndex++;
            }
            // 从左向右找第一个大于等于基准数的元素
            while (leftIndex < rightIndex && array[leftIndex] < baseNumber) {
                leftIndex++;
            }
            // 从上面这个循环出来后如果leftIndex<rightIndex说明自左向右找到了第一个大于等于基准数的元素，
            // 此时取出它填充到a[rightIndex],同时下标rightIndex左移,缩小范围
            if (leftIndex < rightIndex) {
                array[rightIndex] = array[leftIndex];
                rightIndex--;
            }
        }
        // 此时 leftIndex==rightIndex,将基准数填入leftIndex位置
        array[leftIndex] = baseNumber;
        return leftIndex;
    }

    /**
     * 左右指针交换法
     * 1. 选取一个关键字(baseNumber)作为枢轴，一般取整组记录的第一个数/最后一个，这里采用选取序列最后一个数为枢轴。
     * 2. 设置两个变量left = 0;right = N - 1;
     * 3. 从left一直向后走，直到找到一个大于baseNumber的值，right从后至前，直至找到一个小于baseNumber的值，然后交换这两个数。
     * 4. 重复第三步，一直往后找，直到left和right相遇，这时将key放置left的位置即可。
     *
     * @param array      待排序数组
     * @param leftIndex  左始下标
     * @param rightIndex 右始下标
     * @return 左右相等的下标 基准值新的位置
     */
    private static int partQuickSortByPointSwap(int[] array, int leftIndex, int rightIndex) {
        // 首次基准数字取了最后一个元素
//        int baseNumber = array[rightIndex];
        // 优化后基准数字取数组首中尾三数的中间数字
        int baseNumber = array[getBasIndexByMid(array, leftIndex, rightIndex)];
        final int baseIndex = rightIndex;
        while (leftIndex < rightIndex) {
            // 从左向右找第一个小于等于基准数的元素
            while (leftIndex < rightIndex && array[leftIndex] <= baseNumber) {
                leftIndex++;
            }
            // 从右向左找第一个大于基准数的元素
            while (leftIndex < rightIndex && array[rightIndex] >= baseNumber) {
                rightIndex--;
            }
            // 左右交换
            int temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }
        // 此时 left==right 基准元素与相遇点元素交换
        int temp = array[leftIndex];
        array[leftIndex] = baseNumber;
        array[baseIndex] = temp;
        return leftIndex;
    }

    /**
     * 前后指针交换法
     * 1. 定义变量cur指向序列的开头，定义变量pre指向cur的前一个位置。
     * 2. 当array[cur] <  baseNumber 时，cur和pre同时往后走，如果array[cur]>baseNumber，cur往后走，pre留在大于key的数值前一个位置。
     * 3. 当array[cur]再次 < baseNumber 时，交换array[cur]和array[pre]。
     * 4. 当current走到终点时,交换pre++与right位置
     * 通俗一点就是，在没找到大于baseNumber值前，pre永远紧跟cur，遇到大的两者之间就会拉开差距，中间差的肯定是连续的大于baseNumber的值，
     * 当再次遇到小于baseNumber的值时，交换两个下标对应的值就好了。
     *
     * @param array      待排序数组
     * @param leftIndex  左始下标
     * @param rightIndex 右始下标
     * @return 基准值新的位置
     */
    private static int partQuickSortByPrePointSwap(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            // 首次基准数字取了最后一个元素
//            int baseNumber = array[rightIndex];
            // 优化后基准数字取数组首中尾三数的中间数字
            int baseNumber = array[getBasIndexByMid(array, leftIndex, rightIndex)];
            int currentIndex = leftIndex;
            int preIndex = currentIndex - 1;
            while (currentIndex < rightIndex) {
                // 如果找到小于key的值，并且cur和pre之间有距离时则进行交换。注意两个条件的先后位置不能更换
                while (array[currentIndex] < baseNumber && ++preIndex != currentIndex) {
                    int temp = array[currentIndex];
                    array[currentIndex] = array[preIndex];
                    array[preIndex] = temp;
                }
                ++currentIndex;
            }
            // 此时current>=right,交换基准数字即right和pre+1的位置
            int temp = array[rightIndex];
            array[rightIndex] = array[++preIndex];
            array[preIndex] = temp;
            return preIndex;
        }
        return -1;
    }

    /**
     * 三数取中法
     * 上面的代码思想都是直接拿序列的最后一个值作为枢轴，
     * 如果最后这个值刚好是整段序列最大或者最小的值，那么这次划分就是没意义的。
     * 当序列是正序或者逆序时，每次选到的枢轴都是没有起到划分的作用。快排的效率会极速退化。
     * 因此可以每次在选枢轴时，在序列的第一，中间，最后三个值里面选一个中间值出来作为枢轴，保证每次划分接近均等
     *
     * @param array      待排序数组
     * @param leftIndex  左始下标
     * @param rightIndex 右始下标
     * @return 合理的基准数的下标
     */
    private static int getBasIndexByMid(int[] array, int leftIndex, int rightIndex) {

        int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
        if (array[leftIndex] <= array[rightIndex]) {
            if (array[midIndex] < array[leftIndex]) {
                return leftIndex;
            } else if (array[midIndex] > array[rightIndex]) {
                return rightIndex;
            } else {
                return midIndex;
            }
        } else {
            if (array[midIndex] < array[rightIndex]) {
                return rightIndex;
            } else if (array[midIndex] > array[leftIndex]) {
                return leftIndex;
            } else {
                return midIndex;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(2);
        while (scanner.hasNextLine()) {
            final int size = scanner.hasNext() ? Integer.parseInt(scanner.next()) : 0;
            final int[] array1 = new int[size];
            for (int i = 0; i < size; i++) {
                array1[i] = random.nextInt(size * 10);
            }
            final int[] array2 = Arrays.copyOf(array1, array1.length);
            final int[] array3 = Arrays.copyOf(array1, array1.length);
            final int[] array4 = Arrays.copyOf(array1, array1.length);
            System.out.println("快速排序前输入参数为:" + Arrays.toString(array1));
            long beginTime = System.currentTimeMillis();
            quickSortByPit(array1, 0, size - 1);
//            System.out.println("挖坑填数法快速排序输出结果为:" + Arrays.toString(array1));
            System.out.println("挖坑填数法快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
            beginTime = System.currentTimeMillis();
            quickSortByPointSwap(array2, 0, size - 1);
//            System.out.println("左右指针交换法快速排序输出结果为:" + Arrays.toString(array2));
            System.out.println("左右指针交换法快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
            beginTime = System.currentTimeMillis();
            quickSortByPrePointSwap(array3, 0, size - 1);
//            System.out.println("前后指针交换法快速排序输出结果为:" + Arrays.toString(array3));
            System.out.println("前后指针交换法快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
            beginTime = System.currentTimeMillis();
            quickSortNotRecursive(array4, 0, size - 1);
            System.out.println("前后指针交换法快速排序输出结果为:" + Arrays.toString(array4));
            System.out.println("非递归栈快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        }
    }

}
