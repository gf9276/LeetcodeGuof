package com.guof.divisibility_array;


class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] output = new int[word.length()];

        // 找余数
        long remainder = Long.parseLong(String.valueOf(word.charAt(0))) % m;
        if (remainder == 0) {
            output[0] = 1;
        }
        for (int i = 1; i < word.length(); i++) {
            remainder *= 10;
            remainder += Integer.parseInt(String.valueOf(word.charAt(i)));
            remainder %= m;
            if (remainder == 0) {
                output[i] = 1;
            }
        }
        return output;
    }
}