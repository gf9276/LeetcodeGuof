package com.feng.double_index_technique_sliding_window.min_sub_array_len;

/**
 * ClassName: Solution
 * Package: com.feng.double_index_technique_sliding_window.min_sub_array_len
 * Description:
 *
 * @Author guof
 * @Create 2023/5/16 13:25
 * @Version 1.0
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) {
            return 1;
        } else {
            if (nums.length == 1) return 0;
        }

        int slowP = 0;
        int fastP = 1;
        int curValue = nums[0] + nums[1];
        int len = nums.length + 10;


        while (true) {
            if (curValue >= target) {
                // 满足条件，计算当前长度
                len = Math.min(len, fastP - slowP);
                curValue -= nums[slowP];
                slowP++; // 慢指针往前挪一步
            } else {
                // 不满足条件，快指针往前挪一步
                fastP++;
                if (fastP < nums.length) {
                    curValue += nums[fastP];
                } else {
                    break;
                }
            }
        }
        return len == nums.length + 10 ? 0 : len + 1;
    }
}