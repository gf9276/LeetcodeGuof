package com.guof.classical_linear_dp.lis.lc_1671;

import java.util.Arrays;

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //
        int n = nums.length;
        int[] dp1 = new int[n]; // 以i为结尾的最长递增
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1); // 以i为开头得最长递减

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp1[j] = Math.max(dp1[j], dp1[i] + 1);
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    dp2[j] = Math.max(dp2[j], dp2[i] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                res = Math.max(res, dp1[i] + dp2[i] - 1);
            }
        }
        return n - res;
    }
}