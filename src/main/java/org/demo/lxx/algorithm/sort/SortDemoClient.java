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
        final int[] array = Arrays.copyOf(originalArray, originalArray.length);
        final long beginTime = System.currentTimeMillis();
        StraightlyInsertSortDemo.straightlyInsertSort(array);
        log.info("直接插入排序的耗时:" + (System.currentTimeMillis() - beginTime) + "毫秒");
        log.debug("直接插入排序后的结果为:" + Arrays.toString(array));
    }

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random(2);
        while (scanner.hasNextLine()) {
            final int size = scanner.hasNext() ? Integer.parseInt(scanner.next()) : 0;
            final int[] originalArray = new int[size];
            for (int i = 0; i < size; i++) {
                originalArray[i] = random.nextInt(size * 10);
            }
            testQuicklySort(originalArray);
            log.warn("-------------分隔符---------------");
            testStraightlyInsertSort(originalArray);
        }
    }
}
