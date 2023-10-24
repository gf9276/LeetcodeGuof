package com.guof.max_satisfaction;

import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        // 排完序，只剩下选或者不选
        Arrays.sort(satisfaction);

        // 倒着做
        int sum = 0;
        int output = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (sum + satisfaction[i] >= 0) {
                // 说明是有意义的，这道菜我就要做
                output += sum + satisfaction[i];
                sum += satisfaction[i];
            } else {
                break;
            }
        }
        return output;
    }
}