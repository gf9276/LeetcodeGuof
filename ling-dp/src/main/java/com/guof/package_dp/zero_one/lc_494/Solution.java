package com.guof.package_dp.zero_one.lc_494;


import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        return dfs(coins, amount, 0, new Integer[amount + 1][coins.length]);
    }

    public int dfs(int[] coins, int target, int curIdx, Integer[][] memo) {
        if (target < 0) {
            // 不成立了
            return 0;
        }
        if (curIdx >= coins.length) {
            // 到头了
            return target == 0 ? 1 : 0; // 这是一种可能性
        }
        if (memo[target][curIdx] != null) {
            return memo[target][curIdx];
        }

        int ans = 0;
        // 选择当前的，还是切换下一个
        // 当前的
        ans += dfs(coins, target - coins[curIdx], curIdx, memo);
        ans += dfs(coins, target, curIdx + 1, memo);
        memo[target][curIdx] = ans;
        return ans;
    }
}