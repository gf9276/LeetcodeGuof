package com.guof.cmp_2023_12_17_376.find_missing_and_repeated_values;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] output = new int[2];
        int[] arr = new int[grid.length * grid.length + 1];

        for (int[] ints : grid) {
            for (int anInt : ints) {
                arr[anInt]++;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                output[1] = i;
            }
            if (arr[i] == 2) {
                output[0] = i;
            }
        }
        return output;
    }
}