package com.guof.two_dimensional_prefix_and.max_side_length;

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int output = 0;

        for (int i = 0; i < mat.length; i++) {
            int[] input = new int[mat[i].length];
            for (int j = i; j < mat.length && j - i + 1 <= mat[j].length; j++) {
                // j - i + 1 <= mat[j].length 是为了确保能形成正方形
                int sideLength = j - i + 1;
                for (int k = 0; k < mat[j].length; k++) {
                    input[k] += mat[j][k];
                }
                // 获取当前最小和
                int curMin = getMinSum(input, sideLength);
                // 再加下去也没用了，只会越来越大
                if (curMin > threshold) {
                    break;
                }
                // 求最大的边长
                output = Math.max(output, sideLength);
            }
        }
        return output;
    }

    public int getMinSum(int[] input, int sideLength) {
        // 滑动窗口求窗口大小为sideLength的元素和最小值
        int[] dp = new int[input.length + 1];
        int output = Integer.MAX_VALUE;

        for (int i = 1; i < dp.length; i++) {
            if (i < sideLength) {
                dp[i] = dp[i - 1] + input[i - 1];
            } else if (i == sideLength) {
                dp[i] = dp[i - 1] + input[i - 1];
                output = dp[i];
            } else {
                dp[i] = dp[i - 1] + input[i - 1] - input[i - 1 - sideLength];
                output = Math.min(output, dp[i]);
            }
        }
        return output;
    }
}