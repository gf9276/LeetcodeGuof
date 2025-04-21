package com.guof.package_dp.zero_one.lc_1449;

import java.util.Objects;

class Solution {
    public String largestNumber(int[] cost, int target) {
        // target恰好为0
        // 尽量选大的不就好了？
        return dfs(cost, target, new String[target + 1]);
    }

    public String dfs(int[] cost, int target, String[] memo) {
        if (target == 0) {
            return ""; // 正好是一个答案
        }
        if (target < 0) {
            return "0";
        }
        if (memo[target] != null) {
            return memo[target];
        }
        String ans = "";

        for (int i = 1; i < 10; i++) {
            String curAns = dfs(cost, target - cost[i - 1], memo);
            if (curAns.equals("0")) {
                continue;
            }
            curAns = i + curAns;
            if (curAns.length() >= ans.length()) {
                // 因为前面的数字在变大，所以呢，直接大于等于就行了
                ans = curAns;
            }
        }
        if (ans.equals("")) {
            ans = "0";
        }
        memo[target] = ans;
        return ans;
    }
}
