package com.guof.min_increments;


class Solution {
    int output = 0;

    public int minIncrements(int n, int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        output = 0;
        dfs(cost, 1);
        return output;
    }

    public int dfs(int[] cost, int idx) {
        if (idx * 2 > cost.length) {
            // 1 2 4 8 等比数列，这是最后一行了
            return cost[idx - 1];
        }

        // 左右节点的高度
        int left = dfs(cost, idx * 2);
        int right = dfs(cost, idx * 2 + 1);
        output += Math.abs(left - right); // 获取差值值
        return cost[idx - 1] + Math.max(left, right); // 获取当前点的高度
    }
}