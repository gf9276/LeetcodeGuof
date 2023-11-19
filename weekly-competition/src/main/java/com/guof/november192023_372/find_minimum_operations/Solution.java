package com.guof.november192023_372.find_minimum_operations;

import java.util.Arrays;

class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        // 难道不是直接看前面数字是否相同就可以了》
        int[] tmp = {s1.length(), s2.length(), s3.length()};
        Arrays.sort(tmp);
        int n = tmp[0];
        int output = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                output++;
            } else {
                break;
            }
        }
        return output == 0 ? -1 : s1.length() + s2.length() + s3.length() - 3 * output;
    }
}