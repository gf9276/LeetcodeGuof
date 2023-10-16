package com.guof.number_that_only_appears_once2;


class Solution {
    public int singleNumber(int[] nums) {
        int output = 0;
        for (int i = 0; i < 32; i++) {
            // 计算1的个数
            int cnt = 0;
            for (int x : nums) {
                cnt += (x >> i) & 1;
            }
            output += (cnt % 3) << i;
        }
        return output;
    }
}
