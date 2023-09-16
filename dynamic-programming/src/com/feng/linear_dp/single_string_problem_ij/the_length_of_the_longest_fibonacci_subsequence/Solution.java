package com.feng.linear_dp.single_string_problem_ij.the_length_of_the_longest_fibonacci_subsequence;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int output = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int lastToLast = arr[i];
                int penultimate = arr[j];

                int curIdx = map.getOrDefault(lastToLast - penultimate, -1);
                if (curIdx != -1 && curIdx < j) {
                    dp[j][i] = Math.max(dp[curIdx][j] + 1, 3);
                    output = Math.max(output, dp[j][i]);
                }

            }
        }
        return output;
    }
}