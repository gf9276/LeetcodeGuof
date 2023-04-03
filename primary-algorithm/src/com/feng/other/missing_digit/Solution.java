package com.feng.other.missing_digit;

/**
 * ClassName: Solution
 * Package: com.feng.other.missing_digit
 * Description:
 *
 * @Author guof
 * @Create 2023/4/3 22:19
 * @Version 1.0
 */
class Solution {
    public int missingNumber(int[] nums) {
        int out = 0;
        for (int i = 0; i < nums.length; i++) {
            out = out ^ i ^ nums[i];
        }
        out = out ^ nums.length;

        return out;
    }
}