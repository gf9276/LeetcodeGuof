package com.feng.dynamic_programming.jumping_game;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.jumping_game
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 16:38
 * @Version 1.0
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            // 起点就是终点
            return true;
        }
        if (nums.length - 1 <= nums[0]) {
            // 可以从起点直接跳过去
            return true;
        }

        // 当然是最大步数越大越好了
        int[] dp = new int[nums.length]; // 每一个都是当前能到达的最远的位置
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > dp[i - 1]) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
        }

        return true;
    }
}