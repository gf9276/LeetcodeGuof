package com.feng.linear_dp.single_string_problem_other_single_string_dpi_problems.minimum_refueling_times;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            // 直达
            return 0;
        }
        if (stations.length == 0) {
            // 不能直达且没有加油站
            return -1;
        }

        // 达到第i个加油站的加油次数
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 1; i < stations.length + 1; i++) {
            for (int j = i; j >= 1; j--) {
                // 先更新后面的？
                if (dp[j - 1] >= stations[i - 1][0]) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + stations[i - 1][1]);
                }
            }
        }

        for (int i = 0; i < stations.length + 1; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}