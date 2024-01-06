package com.guof.cmp_2024_01_06_121.missing_integer;

import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {
        Integer[] integerNums = new Integer[nums.length + 1];
        integerNums[nums.length] = -1; // 最后一个加一个结束符
        for (int i = 0; i < nums.length; i++) {
            integerNums[i] = nums[i];
        }
        Set<Integer> set = new HashSet<>(Arrays.asList(integerNums));

        int sum = integerNums[0];
        int i = 1;
        for (; i < integerNums.length; i++) {
            if (integerNums[i] != 1 + integerNums[i - 1]) {
                break;
            }
            sum += integerNums[i];
        }

        while (set.contains(sum)) {
            sum++;
        }
        return sum;
    }
}