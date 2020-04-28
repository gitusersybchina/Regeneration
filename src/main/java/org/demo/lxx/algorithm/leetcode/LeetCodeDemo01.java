package org.demo.lxx.algorithm.leetcode;

import java.util.Arrays;


/**
 * Description for this class
 *
 * @author : xiaoshi
 * @version : 1.0
 * @date : 2020/1/2 14:28
 */
public class LeetCodeDemo01 {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
        }
        int[] num3 = Arrays.stream(nums1).sorted().toArray();
        if (m + n >= 0) {
            System.arraycopy(num3, 0, nums1, 0, m + n);
        }
    }

    public static int majorityElement(int[] nums) {

        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    public int singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 0) {
                return nums[i];
            }
        }
        return 0;
    }


    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            for (; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j] && j + 1 < nums.length) {
                    nums[j] = nums[j++];
                }
            }
        }
        return j;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome2(-1));
    }


    public static int reverseLongToInt1(long x) {

        if (-10 < x && x < 10) {
            return (int) x;
        }
        long xx = x;
        boolean flag = false;
        if (xx < 0) {
            xx *= -1;
            flag = true;
        }
        final StringBuilder sb = new StringBuilder();
        while (xx != 0) {
            sb.append(xx % 10);
            xx /= 10;
        }
        if (sb.length() == 0) {
            return 0;
        }
        final long temp = Long.parseLong(sb.toString());
        if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
            return 0;
        }
        final int result = Integer.parseInt(Long.toString(temp));
        return flag ? -result : result;
    }

    public static int reverseLongToInt2(long x) {

        int result = 0;
        while (x != 0) {
            int temp = (int) (x % 10 + result * 10);
            // 反向操作后不能还原
            if ((temp - x % 10) / 10 != result) {
                return 0;
            }
            x /= 10;
            result = temp;
        }
        return result;
    }

    /**
     * 执行耗时:21 ms,击败了7.00% 的Java用户
     * 内存消耗:39.3 MB,击败了5.14% 的Java用户
     */
    public static boolean isPalindrome1(long x) {

        if (x < 0) {
            return false;
        }
        final StringBuilder builder = new StringBuilder();
        final long original = x;
        while (x != 0) {
            builder.append(x % 10);
            x /= 10;
        }
        return Integer.parseInt(builder.toString()) == original;
    }

    /**
     * 执行耗时:12 ms,击败了38.22% 的Java用户
     * 内存消耗:39.7 MB,击败了5.14% 的Java用户
     */
    public static boolean isPalindrome2(long x) {

        final StringBuilder builder = new StringBuilder();
        builder.append(x);
        final String original = builder.toString();
        return builder.reverse().toString().equals(original);
    }
}
