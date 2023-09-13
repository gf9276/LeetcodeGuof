package com.feng.linear_dp.single_string_problem_the_most_classic_single_string_lis_series.russian_doll_envelope_issue;

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 感觉不难，动态规划，第p+1个信封里能套的个数为剩下信封里能套个数最大值+1
        // 动态规划会爆掉的，这题只能贪心+二分法插入（效率高）

        // 排序，宽度升序，宽度相同则高度降序
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });

        // 贪心+二分，不停插入新的值到指定idx
        int[] dp = new int[envelopes.length];
        int output = 0;
        for (int[] envelope : envelopes) {
            int curH = envelope[1];
            int idx = Arrays.binarySearch(dp, 0, output, curH);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            dp[idx] = curH;
            if (idx == output) {
                // 扩容
                output++;
            }
        }
        return output;
    }
}