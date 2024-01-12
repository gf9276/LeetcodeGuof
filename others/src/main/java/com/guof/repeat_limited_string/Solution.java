package com.guof.repeat_limited_string;


import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] nbrs = new int[26];
        StringBuilder output = new StringBuilder();
        for (char c : s.toCharArray()) {
            nbrs[c - 'a']++;
        }

        int left = 25;
        int right = 24;

        while (left >= 0) {
            for (int j = 0; j < repeatLimit && nbrs[left] > 0; j++) {
                nbrs[left]--;
                output.append((char) ('a' + left));
            }
            if (nbrs[left] == 0) {
                left--;
                right = Math.min(right, left - 1);
            } else {
                while (right >= 0 && nbrs[right] == 0) {
                    right--;
                }
                if (right < 0) {
                    break;
                }
                nbrs[right]--;
                output.append((char) ('a' + right));
            }
        }

        return output.toString();
    }
}