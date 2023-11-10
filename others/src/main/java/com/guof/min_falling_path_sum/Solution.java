package com.guof.min_falling_path_sum;


import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // 还是用dp，给个面子，嘻嘻
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // 最大堆
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            if (heap.size() < 2) {
                heap.add(new Integer[]{dp[0][i], i});
            } else {
                if (dp[0][i] < heap.peek()[0]) {
                    heap.poll();
                    heap.add(new Integer[]{dp[0][i], i});
                }
            }
        }

        for (int i = 1; i < m; i++) {
            int secondMinIdx = heap.poll()[1];
            int firstMinIdx = heap.poll()[1];
            for (int j = 0; j < n; j++) {
                if (j != firstMinIdx) {
                    dp[i][j] = dp[i - 1][firstMinIdx] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][secondMinIdx] + matrix[i][j];
                }
                if (heap.size() < 2) {
                    heap.add(new Integer[]{dp[i][j], j});
                } else {
                    if (dp[i][j] < heap.peek()[0]) {
                        heap.poll();
                        heap.add(new Integer[]{dp[i][j], j});
                    }
                }
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}