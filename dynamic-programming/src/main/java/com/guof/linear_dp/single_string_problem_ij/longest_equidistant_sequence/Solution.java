package com.guof.linear_dp.single_string_problem_ij.longest_equidistant_sequence;

import java.util.Arrays;

class Solution {
    public int longestArithSeqLength(int[] arr) {
        int output = Math.min(arr.length, 2);
        int[][] dp = new int[arr.length][arr.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, 2);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int lastToLast = arr[i];
                int penultimate = arr[j];
                int difference = lastToLast - penultimate;
                int curIdx = -1;
                for (int k = j - 1; k >= 0; k--) {
                    if (arr[k] == penultimate - difference) {
                        curIdx = k;
                        break;
                    }
                }
                if (curIdx != -1) {
                    dp[j][i] = dp[curIdx][j] + 1;
                    output = Math.max(output, dp[j][i]);
                }

            }
        }
        return output;
    }
}