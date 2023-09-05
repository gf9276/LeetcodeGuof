package com.feng.practical_application_hash_set.num_that_only_appears_once;

class Solution {
    public int singleNumber(int[] nums) {
        // 位运算是最优解

        int output = 0;
        for (int i : nums) {
            output ^= i;
        }
        return output;
    }
}