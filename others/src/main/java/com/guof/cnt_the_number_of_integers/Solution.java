package com.guof.cnt_the_number_of_integers;


import java.math.BigDecimal;

class Solution {
    int min_sum;
    int max_sum;

    Integer[][] dp;
    int mod = 1000000007;

    public int count(String num1, String num2, int _min_sum, int _max_sum) {
        min_sum = _min_sum;
        max_sum = _max_sum;

        dp = new Integer[23][220]; // 就算全是9，也只不过是 22*9 罢了，220还多了
        int ans2 = dfs(num2, 0, 0, true);

        dp = new Integer[23][220]; // 就算全是9，也只不过是 22*9 罢了，220还多了
        num1 = new BigDecimal(num1).subtract(BigDecimal.ONE).toString();
        int ans1 = dfs(num1, 0, 0, true);

        return (ans2 - ans1 + mod) % mod;
    }

    public int dfs(String num, int curPos, int curSum, boolean limit) {
        if (num.length() == curPos) {
            return curSum <= max_sum && curSum >= min_sum ? 1 : 0;
        }
        if (!limit && dp[curPos][curSum] != null) {
            // 如果是无敌状态的，直接跳过，否则按照下面的自己算一次
            return dp[curPos][curSum];
        }

        int maxDig = limit ? num.charAt(curPos) - '0' : 9; // 当前位置的最大值
        int ans = 0;
        for (int i = 0; i <= maxDig; i++) {
            // 当前位置选择 i ，则dp[i][curSum+i]数量变化
            ans = (ans + dfs(num, curPos + 1, curSum + i, limit & (i == maxDig))) % mod;
        }
        if (!limit) {
            // 只记录无敌状态
            dp[curPos][curSum] = ans;
        }
        return ans;
    }
}