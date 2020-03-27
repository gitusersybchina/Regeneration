package org.demo.lxx.algorithm;

import java.util.Arrays;


/**
 * Description for this class
 *
 * @author : yinbo.shi@hand-china.com
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
            for ( ;j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j] && j + 1 < nums.length) {
                    nums[j] = nums[j ++];
                }
            }
        }
        return j;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
//        merge(nums1, 3, nums2, 3);


    }
}
