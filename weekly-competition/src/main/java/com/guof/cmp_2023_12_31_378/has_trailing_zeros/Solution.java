package com.guof.cmp_2023_12_31_378.has_trailing_zeros;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int[] lowBitNums = new int[2]; // 尾号为0或者为1的数字的个数

        for (int num : nums) {
            if (num % 2 == 0) {
                lowBitNums[0]++;
            } else {
                lowBitNums[1]++;
            }
        }

        return lowBitNums[0] >= 2;
    }
}