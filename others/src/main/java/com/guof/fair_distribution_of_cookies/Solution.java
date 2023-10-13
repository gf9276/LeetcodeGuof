package com.guof.fair_distribution_of_cookies;


import java.util.Arrays;

class Solution {
    public int distributeCookies(int[] cookies, int k) {
        // 2 <= cookies.length <= 8，所以最多不过2^8
        int target = 2 << cookies.length; // 二进制表示，0表示当前饼干没发，1表示发了
        int[][] dp = new int[k + 1][target]; // 前n个孩子，分饼干情况，从000...000到111...111，下的最小不公平值
        // 当有一个为0，都是0，毕竟没有孩子或者说没有饼干的时候，不公平值自然为0

        // 当情况为s时，不公平，饼干分数之和
        int[] g = new int[target];
        for (int s = 0; s < target; s++) {
            int t = 0;
            for (int i = 0; i < cookies.length; i++) {
                t += ((s >> i) & 1) == 1 ? cookies[i] : 0; // 有这个饼干，为1
            }
            g[s] = t;
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE); // 默认都是最大
        }

        // 没有小孩，就没有意义了
        Arrays.fill(dp[0], Integer.MAX_VALUE);

        // 没有饼干，自然是0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // 开始分饼干
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                // 前i个小孩，饼干情况为j, 要找j的子集了
                for (int p = j; p > 0; p--) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][j - (p & j)], g[p & j]));
                }
            }
        }
        return dp[k][target - 1];
    }
}