package com.guof.cmp_2024_02_17_124.maximum_nbr_of_operations_with_the_same_score1;

class Solution {
    public int maxOperations(int[] nums) {
        int output = 0;
        int lastScore = -1;
        for (int i = 0; i + 1 < nums.length; i += 2) {
            int curScore = nums[i] + nums[i + 1];
            if (lastScore == -1) {
                lastScore = curScore;
            } else {
                if (lastScore != curScore) {
                    break;
                }
            }
            output++;
        }
        return output;
    }
}