package com.feng.arrays_and_strings.incremental_ternary_subsequence;

/**
 * ClassName: Solution
 * Package: com.feng.incremental_ternary_subsequence
 * Description:
 *
 * @Author guof
 * @Create 2023/4/5 20:47
 * @Version 1.0
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
//        int min = Integer.MAX_VALUE;  // 最小值
//        int min_2 = Integer.MAX_VALUE; // 第二小值
//
//        for (int num : nums) {
//            if (num < min) {
//                min = num;
//            } else if (num > min_2) {
//                return true;
//            } else if (num > min && num < min_2) {
//                min_2 = num;
//            }
//
//        }
//        return false;

        int min = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > min_2) {
                return true;
            } else if (num > min && num < min_2) {
                min_2 = num;
            }
        }
        return false;
    }
}