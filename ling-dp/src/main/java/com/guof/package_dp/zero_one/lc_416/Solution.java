package com.guof.package_dp.zero_one.lc_416;


import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int avg = sum / 2;
        return dfs(nums, 0, avg, new Boolean[nums.length][avg + 1]);
    }

    public boolean dfs(int[] nums, int curI, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (curI >= nums.length) {
            // 超出去了
            return false;
        }
        if (memo[curI][target] != null) {
            return memo[curI][target];
        }
        // 选
        boolean ans = false;
        if (nums[curI] <= target) {
            ans = dfs(nums, curI + 1, target - nums[curI], memo);
        }
        // 补选
        ans |= dfs(nums, curI + 1, target, memo);
        memo[curI][target] = ans;
        return ans;
    }
}