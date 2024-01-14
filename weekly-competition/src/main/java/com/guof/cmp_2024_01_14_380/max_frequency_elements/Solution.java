package com.guof.cmp_2024_01_14_380.max_frequency_elements;

import java.util.Arrays;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freqs = new int[101];

        int max = 0;
        for (int num : nums) {
            freqs[num]++;
            max = Math.max(freqs[num], max);
        }

        int output = 0;

        for (int freq : freqs) {
            if (freq == max) {
                output += max;
            }
        }
        return output;
    }
}