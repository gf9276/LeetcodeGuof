package com.feng.linear_dp.single_string_problem_other_single_string_dpi_problems.the_minimum_number_of_exchanges_to_increment_the_sequence;

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        // 我直接大彻大悟，原来只能交换同一个i的数字，那就方便多了
        int n1 = 0, s1 = 1;
        for (int i = 1; i < nums1.length; i++) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                // 要么都换，要么都别换
                n2 = Math.min(n1, n2);
                s2 = Math.min(s1 + 1, s2);
            }

            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                // ？
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }

            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }
}