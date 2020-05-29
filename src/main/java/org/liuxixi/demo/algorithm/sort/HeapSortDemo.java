package org.liuxixi.demo.algorithm.sort;

/**
 * 堆排序示例
 * <p>
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。（大根堆、小根堆）
 * <p>
 * 因为每次将堆调整为最大（小）堆后，堆的根结点一定是堆中最大（小）的元素。
 * 通过不停的取出最大（小）堆的根节点和重新调整为最大（小）堆，就可以一直得到未排序数组的最大（小）值。
 * <p>
 * 一般都用数组来表示堆，i结点的父结点下标就为(i–1)/2。它的左右子结点下标分别为2 * i + 1和2 * i + 2。
 * <p>
 * 平均时间复杂度 O(n*log2n) 空间复杂度 O(1)  具有不稳定性
 *
 * @author : xiaoshiyb@163.com
 * @version : 1.0
 * @date : 2020/3/30 15:41
 */
public class HeapSortDemo {


    /**
     * 以升序为例，算法实现的思路为：
     * 1. 建立一个 heapBuild 函数，将数组 tree[0,...n-1] 建立成堆，n 表示数组长度。
     * 函数里需要维护的是所有节点的父节点，最后一个子节点下标为 n-1，那么它对应的父节点下标就是 (n-1-1)/2。
     * 2. 构建完一次堆后，最大元素就会被存放在根节点 tree[0]。
     * 将 tree[0] 与最后一个元素交换，每一轮通过这种不断将最大元素后移的方式，来实现排序。
     * 3. 而交换后新的根节点可能不满足堆的特点了，因此需要一个调整函数 heapAdjust 来对剩余的数组元素进行最大堆性质的维护。
     * 如果 tree[i] 表示其中的某个节点，那么 tree[2*i+1] 是左孩子，tree[2*i+2] 是右孩子，选出三者中的最大元素的下标，存放于 max 值中，
     * 若 max 不等于 i，则将最大元素交换到 i 下标的位置。但是，此时以 tree[max] 为根节点的子树可能不满足堆的性质，需要递归调用自身。
     */
    public static void heapSort(int[] array) {

        int length = array.length;
        int lastIndex = length - 1;
        // 构建一个大根堆
        maxHeapBuild(array, length);
        // 通过调整堆完成排序
        for (int i = lastIndex; i > 0; i--) {
            // 将堆顶元素与最后一个元素交换
            SortDemoUtils.swap(array, 0, i);
            // 这里--length意味着最后一个元素被取出不参与调整
            adjustMaxHeap(array, i, 0);
        }
    }

    /**
     * 将数组大根堆化
     *
     * @param array  待堆化数组
     * @param length 数组长度
     */
    private static void maxHeapBuild(int[] array, int length) {

        // 最后一个节点的下标
        final int lastIndex = length - 1;
        // 最后一个节点对应的父节点下标
        final int parentIndex = (lastIndex - 1) / 2;
        for (int i = parentIndex; i >= 0; i--) {
            adjustMaxHeap(array, length, i);
        }
    }

    /**
     * 将堆调整成大根堆
     *
     * @param array              待调整的堆
     * @param length             堆元素数量
     * @param currentParentIndex 当前堆父节点下标
     */
    private static void adjustMaxHeap(int[] array, int length, int currentParentIndex) {

        if (currentParentIndex < length) {
            // 左子节点下标
            final int leftChildIndex = 2 * currentParentIndex + 1;
            // 右子节点下标
            final int rightChildIndex = 2 * currentParentIndex + 2;
            // 默认parent节点大于子节点
            int maxNumberIndex = currentParentIndex;
            // 找到真正的最大值下标
            if (leftChildIndex < length && array[leftChildIndex] > array[maxNumberIndex]) {
                maxNumberIndex = leftChildIndex;
            }
            if (rightChildIndex < length && array[rightChildIndex] > array[maxNumberIndex]) {
                maxNumberIndex = rightChildIndex;
            }
            // 如果当前父节点不是最大值则交换其于最大值,继续调整
            if (maxNumberIndex != currentParentIndex) {
                SortDemoUtils.swap(array, maxNumberIndex, currentParentIndex);
                adjustMaxHeap(array, length, maxNumberIndex);
            }
        }

    }

}
