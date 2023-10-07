package com.guof.prefix_sum_and_suffix_sum.flip_string_to_monotonically_increasing;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] dpLeft = new int[s.length()];
        // 不包括自身
        for (int i = 1; i < dpLeft.length; i++) {
            dpLeft[i] = dpLeft[i - 1];
            if (s.charAt(i - 1) == '1') {
                dpLeft[i] += 1;
            }
        }

        int output = dpLeft[dpLeft.length - 1];
        int dpRight = 0;
        // 不包括自身
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i + 1) == '0') {
                dpRight++;
            }
            output = Math.min(dpLeft[i] + dpRight, output);
        }

        return output;
    }
}