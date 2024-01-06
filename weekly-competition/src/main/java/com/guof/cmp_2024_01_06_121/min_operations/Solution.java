package com.guof.cmp_2024_01_06_121.min_operations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minOperations(int[] nums, int k) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        num ^= k; // 不同为1，表示需要翻转一次

        int output = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                output++;
            }
            num /= 2;
        }

        return output;

    }
}