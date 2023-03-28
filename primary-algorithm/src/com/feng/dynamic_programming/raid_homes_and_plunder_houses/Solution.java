package com.feng.dynamic_programming.raid_homes_and_plunder_houses;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.raid_homes_and_plunder_houses
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 23:09
 * @Version 1.0
 */
class Solution {
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp0 = 0;
        int dp1 = nums[0];
        int tmp;

        for (int i = 1; i < nums.length; i++) {
            tmp = dp0;
            dp0 = Math.max(dp0, dp1); // 不偷东西，前一天偷不偷无所谓
            dp1 = tmp + nums[i];//偷东西，前一天不能偷东西
        }

        return Math.max(dp0, dp1); // 看看最后一天的成果
    }
}