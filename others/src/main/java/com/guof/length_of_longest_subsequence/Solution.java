package com.guof.length_of_longest_subsequence;


import java.util.List;

class Solution {
    Integer[][] dp;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new Integer[nums.size() + 1][target + 1]; // 前 n 个 数字，和为 j 情况下，满足最终和为target的最长子串长度

        int ans = dfs(nums, target, 0, 0);
        return ans < 0 ? -1 : ans;
    }


    public int dfs(List<Integer> nums, int target, int curPosition, int curSum) {
        if (nums.size() == curPosition) {
            // 到达末尾，结束了
            return curSum == target ? 0 : -0x3f3f3f;
        }

        if (dp[curPosition][curSum] != null) {
            return dp[curPosition][curSum];
        }

        // 当前position，不选
        int ans = dfs(nums, target, curPosition + 1, curSum);
        // 选择当前position
        if (curSum + nums.get(curPosition) <= target) {
            ans = Math.max(ans, dfs(nums, target, curPosition + 1, curSum + nums.get(curPosition)) + 1);
        }

        dp[curPosition][curSum] = ans;

        return ans;
    }
}