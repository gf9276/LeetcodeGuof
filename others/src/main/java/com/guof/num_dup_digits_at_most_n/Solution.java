package com.guof.num_dup_digits_at_most_n;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
    Integer[][] dp;

    public int numDupDigitsAtMostN(int n) {
        // 求未重复数字的个数
        String string = String.valueOf(n);
        dp = new Integer[string.length()][1 << 10]; // 选过的数字，置1
        return n - dfs(string, 0, 0, true);
    }

    public int dfs(String num, int curPos, int mask, boolean limit) {
        if (curPos == num.length()) {
            return mask != 0 ? 1 : 0;
        }
        if (!limit && dp[curPos][mask] != null) {
            return dp[curPos][mask];
        }
        int maxDig = limit ? num.charAt(curPos) - '0' : 9; // 当前位置的最大值
        int ans = 0;
        if (mask == 0) {
            ans = dfs(num, curPos + 1, mask, false);
        }
        for (int i = mask != 0 ? 0 : 1; i <= maxDig; i++) {
            if ((mask & (1 << i)) != 0) {
                // 选过的跳过
                continue;
            }
            ans += dfs(num, curPos + 1, mask | (1 << i), limit & (i == maxDig));
        }
        if (!limit) {
            dp[curPos][mask] = ans;
        }
        return ans;
    }
}