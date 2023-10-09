package com.guof.prefix_product_and_prefix_xor.count_triplets;

class Solution {
    public int countTriplets(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = arr[i - 1] ^ dp[i - 1];
        }

        int output = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                for (int k = j; k < dp.length; k++) {
                    if ((dp[j - 1] ^ dp[i - 1]) == (dp[k] ^ dp[j - 1])) {
                        output++;
                    }
                }
            }
        }
        return output;
    }
}