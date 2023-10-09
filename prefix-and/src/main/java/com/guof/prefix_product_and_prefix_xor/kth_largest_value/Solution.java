package com.guof.prefix_product_and_prefix_xor.kth_largest_value;

import java.util.PriorityQueue;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        // 就是一个矩阵里全部异或呗，切

        int[][] dp = new int[matrix.length][matrix[0].length];
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 维护一个最小堆，这个堆的大小始终为k

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] ^= matrix[i][j];
                if (i - 1 >= 0) {
                    dp[i][j] ^= dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] ^= dp[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] ^= dp[i - 1][j - 1];
                }

                if (heap.size() < k) {
                    heap.add(dp[i][j]);
                } else {
                    if (heap.peek() < dp[i][j]) {
                        heap.poll();
                        heap.add(dp[i][j]);
                    }
                }
            }
        }

        return heap.peek();
    }
}