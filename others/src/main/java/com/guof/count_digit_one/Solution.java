package com.guof.count_digit_one;


import java.math.BigDecimal;

class Solution {
    Integer[][] dp;

    public int countDigitOne(int n) {
        String string = String.valueOf(n);
        dp = new Integer[string.length() + 1][string.length() + 1];
        return dfs(string, 0, 0, true, false);
    }

    public int dfs(String num, int curPose, int cntOne, boolean limit, boolean isNum) {
        if (curPose == num.length()) {
            return isNum ? cntOne : 0;
        }

        if (!limit && dp[curPose][cntOne] != null) {
            return dp[curPose][cntOne];
        }
        int ans = 0;
        if (!isNum) {
            ans = dfs(num, curPose + 1, cntOne, false, false);
        }

        int up = limit ? num.charAt(curPose) - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            ans += dfs(num, curPose + 1, cntOne + (i == 1 ? 1 : 0), limit & (i == up), true);
        }

        if (!limit) {
            dp[curPose][cntOne] = ans;
        }
        return ans;
    }
}