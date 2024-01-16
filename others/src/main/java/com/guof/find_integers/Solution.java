package com.guof.find_integers;


class Solution {
    Integer[][] dp;

    public int findIntegers(int n) {
        StringBuilder string = new StringBuilder();

        while (n != 0) {
            string.insert(0, (char) ('0' + n % 2));
            n /= 2;
        }

        dp = new Integer[string.length() + 1][2];


        return dfs(string.toString(), 0, 0, true, false);
    }

    public int dfs(String num, int curPose, int lastNbr, boolean limit, boolean isNum) {
        if (curPose == num.length()) {
            return 1;
        }

        if (!limit && dp[curPose][lastNbr] != null) {
            return dp[curPose][lastNbr];
        }

        int ans = 0;
        if (!isNum) {
            // 全部填0，一路同行
            ans = dfs(num, curPose + 1, 0, false, false);
        }

        int up = limit ? num.charAt(curPose) - '0' : 1;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            if (i == 1 && lastNbr == 1) {
                // 不能连续1啊
                continue;
            }
            ans += dfs(num, curPose + 1, i, limit & (up == i), true);
        }
        if (!limit) {
            dp[curPose][lastNbr] = ans;
        }

        return ans;
    }
}