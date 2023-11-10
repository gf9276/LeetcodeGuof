package com.guof.count_routes;


class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        // 所有 locations 中的整数 互不相同，所以，最多动fuel次
        int[][] dp = new int[fuel + 1][locations.length]; // 恰好用 n 油，抵达终点 idx 的机会

        // 默认都是0，除了，起点
        dp[0][start] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                // 终点为j，起点，自己选
                for (int k = 0; k < dp[i].length; k++) {
                    if (k == j) {
                        // 不允许自己到自己，搁着卡bug是吧
                        continue;
                    }
                    int cost = Math.abs(locations[k] - locations[j]);
                    dp[i][j] = (dp[i][j] + (i - cost >= 0 ? dp[i - cost][k] : 0)) % 1000000007;
                }
            }
        }
        int output = 0;
        for (int[] ints : dp) {
            output += ints[finish];
            output %= 1000000007;
        }
        return output;
    }
}