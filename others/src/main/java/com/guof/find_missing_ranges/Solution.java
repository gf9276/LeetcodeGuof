package com.guof.find_missing_ranges;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int left = lower;
        List<List<Integer>> output = new ArrayList<>();

        // 找到第一个缺失的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != left) {
                break;
            }
            left++;
        }

        int curN = 0;
        while (curN < nums.length) {
            if (left < nums[curN]) {
                output.add(new ArrayList<>(Arrays.asList(left, nums[curN] - 1)));
                left = nums[curN];
                for (int i = curN; i < nums.length; i++) {
                    if (nums[i] != left) {
                        break;
                    }
                    left++;
                }
            }
            curN++;
        }

        if (left <= upper) {
            output.add(new ArrayList<>(Arrays.asList(left, upper)));
        }
        return output;
    }
}