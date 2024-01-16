package com.guof.find_maximum_number;


import java.util.Arrays;

class Solution {
    Long[][] dp;
    int x;


    public long findMaximumNumber(long _k, int _x) {
        x = _x;

        long left = 0;
        long right = (_k + 1) << x;
        while (left < right) {
            long mid = (right - left) / 2 + left;
            long curNbr = countDigitOne(mid);

            if (curNbr <= _k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private long countDigitOne(long num) {
        if (num == 0) {
            return 0;
        }
        int m = 64 - Long.numberOfLeadingZeros(num);
        dp = new Long[m + 1][m + 1];
        StringBuilder string = new StringBuilder();
        while (num != 0) {
            string.insert(0, (char) ('0' + num % 2));
            num /= 2;
        }
        return dfs(string.toString(), 0, 0, true, false);
    }


    public long dfs(String num, int curPose, int cntOne, boolean limit, boolean isNum) {
        if (curPose == num.length()) {
            return isNum ? cntOne : 0;
        }

        if (!limit && dp[curPose][cntOne] != null) {
            return dp[curPose][cntOne];
        }
        long ans = 0;
        if (!isNum) {
            ans = dfs(num, curPose + 1, cntOne, false, false);
        }

        int up = limit ? num.charAt(curPose) - '0' : 1;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            int curBit = num.length() - curPose;
            ans += dfs(num,
                    curPose + 1,
                    cntOne + (((curBit % x == 0) && (i == 1)) ? 1 : 0),
                    limit & (i == up),
                    true);
        }

        if (!limit) {
            dp[curPose][cntOne] = ans;
        }
        return ans;
    }
}