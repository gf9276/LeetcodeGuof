package com.guof.max_div_score;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxScore = Integer.MIN_VALUE;
        int output = 0;

        for (int divisor : divisors) {
            int curScore = 0;
            for (int key : map.keySet()) {
                if (key % divisor == 0) {
                    curScore += map.get(key);
                }
            }
            if (curScore > maxScore) {
                maxScore = curScore;
                output = divisor;
            }
        }
        return output;
    }
}