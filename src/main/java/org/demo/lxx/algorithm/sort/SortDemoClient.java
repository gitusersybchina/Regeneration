package org.demo.lxx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试各种排序类
 *
 * @author : yinbo.shi@hand-china.com
 * @version : 1.0
 * @date : 2020/3/26 18:00
 */
@Slf4j
public class SortDemoClient {


    public static void testBucketSort(int[] originalArray) {

        log.debug("桶排序+直接插入排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        BucketSortDemo.bucketSort(array1, SortDemoUtils.DEFAULT_BUCKET_QUANTITY);
        log.info("通过桶排序+直接插入排序排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("通过桶排序+直接插入排序后输出结果为:" + Arrays.toString(array1));
    }


    public static void testCountingSort(int[] originalArray) {

        log.debug("计数排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        CountingSortDemo.countingSortByRange(array1);
        log.info("通过范围计数排序排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("通过范围计数排序后输出结果为:" + Arrays.toString(array1));

        final int[] array2 = Arrays.copyOf(originalArray, originalArray.length);
        beginTime = System.currentTimeMillis();
        CountingSortDemo.countingSortByMaxValue(array2);
        log.info("通过最大值计数排序排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("通过最大值计数排序后输出结果为:" + Arrays.toString(array2));
    }


    public static void testHeapSort(int[] originalArray) {

        log.debug("堆排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        HeapSortDemo.heapSort(array1);
        log.info("堆排序排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("堆排序后输出结果为:" + Arrays.toString(array1));
    }


    public static void testMergeSort(int[] originalArray) {

        log.debug("归并排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        MergeSortDemo.mergeSort(array1);
        log.info("归并排序排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("归并排序后输出结果为:" + Arrays.toString(array1));
    }


    public static void testShellSort(int[] originalArray) {

        log.debug("希尔排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        ShellSortDemo.shellSort(array1);
        log.info("希尔排序排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("希尔排序后输出结果为:" + Arrays.toString(array1));
    }


    public static void testSampleSelectSort(int[] originalArray) {

        log.debug("简单选择排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        SelectionSortDemo.sampleSelectSort(array1);
        log.info("简单选择排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("简单选择排序后输出结果为:" + Arrays.toString(array1));
    }


    public static void testBubbleSort(int[] originalArray) {

        log.debug("冒泡排序前输入参数为:" + Arrays.toString(originalArray));

        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        long beginTime = System.currentTimeMillis();
        BubbleSortDemo.bubbleSort(array1);
        log.info("冒泡排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("冒泡排序后输出结果为:" + Arrays.toString(array1));

        final int[] array2 = Arrays.copyOf(originalArray, originalArray.length);
        beginTime = System.currentTimeMillis();
        BubbleSortDemo.bubbleSortOptimization(array2);
        log.info("优化后的冒泡排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("优化后的冒泡排序后输出结果为:" + Arrays.toString(array2));
    }


    public static void testQuicklySort(int[] originalArray) {

        log.debug("快速排序前输入参数为:" + Arrays.toString(originalArray));

        final int size = originalArray.length;
        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        final int[] array2 = Arrays.copyOf(originalArray, originalArray.length);
        final int[] array3 = Arrays.copyOf(originalArray, originalArray.length);
        final int[] array4 = Arrays.copyOf(originalArray, originalArray.length);

        long beginTime = System.currentTimeMillis();
        QuicklySortDemo.quickSortByPit(array1, 0, size - 1);
        log.info("挖坑填数法快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("挖坑填数法快速排序输出结果为:" + Arrays.toString(array1));

        beginTime = System.currentTimeMillis();
        QuicklySortDemo.quickSortByPointSwap(array2, 0, size - 1);
        log.info("左右指针交换法快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("左右指针交换法快速排序输出结果为:" + Arrays.toString(array2));

        beginTime = System.currentTimeMillis();
        QuicklySortDemo.quickSortByPrePointSwap(array3, 0, size - 1);
        log.info("前后指针交换法快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("前后指针交换法快速排序输出结果为:" + Arrays.toString(array3));

        beginTime = System.currentTimeMillis();
        QuicklySortDemo.quickSortNotRecursive(array4, 0, size - 1);
        log.info("非递归栈快速排序耗时为:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("非递归栈快速排序输出结果为:" + Arrays.toString(array4));
    }

    public static void testStraightlyInsertSort(int[] originalArray) {

        log.debug("直接插入排序前输入参数为:" + Arrays.toString(originalArray));
        final int[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        final int[] array2 = Arrays.copyOf(originalArray, originalArray.length);

        long beginTime = System.currentTimeMillis();
        InsertionSortDemo.straightlyInsertSort(array1);
        log.info("直接插入排序的耗时:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("直接插入排序后的结果为:" + Arrays.toString(array1));

        beginTime = System.currentTimeMillis();
        InsertionSortDemo.preIndexInsertSort(array2);
        log.info("前后指针插入排序的耗时:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("前后指针插入排序后的结果为:" + Arrays.toString(array2));
    }

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        while (scanner.hasNextLine()) {
            final int size = scanner.hasNext() ? Integer.parseInt(scanner.next()) : 0;
            final int[] originalArray = new int[size];
            for (int i = 0; i < size; i++) {
                originalArray[i] = random.nextInt(size * 10);
            }
            // log.warn("-------------分隔符---------------");
            // testQuicklySort(originalArray);
            // log.warn("-------------分隔符---------------");
            // testStraightlyInsertSort(originalArray);
            // log.warn("-------------分隔符---------------");
            // testBubbleSort(originalArray);
            // log.warn("-------------分隔符---------------");
            // testSampleSelectSort(originalArray);
            // log.warn("-------------分隔符---------------");
            // testShellSort(originalArray);
            // log.warn("-------------分隔符---------------");
            // testMergeSort(originalArray);
            // log.warn("-------------分隔符---------------");
            // testHeapSort(originalArray);
            // log.warn("-------------分隔符---------------");
            testCountingSort(originalArray);
            log.warn("-------------分隔符---------------");
            testBucketSort(originalArray);
        }
    }
}
