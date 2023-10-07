package com.guof.one_dimensional_prefix_and.building_palindrome_string_detection;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> output = new ArrayList<>();
        int[] cnt = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            cnt[i + 1] = cnt[i] ^ (1 << (s.charAt(i) - 'a'));
        }

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1] + 1;
            int k = query[2];

            int curNbr = cnt[right] ^ cnt[left];

            int oddNbr = 0;

            while (curNbr > 0) {
                if (curNbr % 2 == 1) {
                    oddNbr++;
                }
                curNbr /= 2;
            }
            output.add(oddNbr <= k * 2 + 1);
        }

        return output;
    }

}