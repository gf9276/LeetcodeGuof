package com.guof.number_that_only_appears_once3;


class Solution {
    public int[] singleNumber(int[] nums) {
        // 找到c = a^b
        int c = 0;
        for (int num : nums) {
            c ^= num;
        }
        // 寻找a和b不同的位
        int tmp = 1;
        while ((c & tmp) == 0) {
            tmp = tmp << 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((tmp & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}