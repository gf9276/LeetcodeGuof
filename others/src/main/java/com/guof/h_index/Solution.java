package com.guof.h_index;


import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // 排个序先
        int[] arr = new int[citations.length + 1]; // h指数至多为citations.length

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < Math.min(citations[i - 1] + 1, arr.length); j++) {
                arr[j] += 1;
            }
        }

        int output = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            output = Math.max(output, Math.min(i, arr[i]));
        }
        return output;
    }
}