package com.guof.minimal_molecular_ssequence;


class Solution {
    public int minimumScore(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int sSize = s.length();
        int tSize = t.length();

        int[] suffix = new int[sSize + 1]; // 以 i 为中心，分割前后，suffix[i]表示t中满足s后缀的最大坐标

        suffix[sSize] = tSize; // 后面都没有了，分个几把
        for (int i = sSize - 1, j = tSize - 1; i >= 0; i--) {
            if (j >= 0 && sChars[i] == tChars[j]) {
                j--;
            }
            suffix[i] = j + 1;
        }

        int[] prefix = new int[sSize + 1]; // 以 i 为中心，分割前后，prefix[i]表示t中满足s前缀的最大结束坐标
        prefix[0] = -1; // 在第0个的前面一个

        for (int i = 1, j = 0; i <= sSize; i++) {
            if (j <= tSize - 1 && sChars[i - 1] == tChars[j]) {
                j++;
            }
            prefix[i] = j - 1;
        }

        int output = Integer.MAX_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            output = Math.min(output, Math.max(0, suffix[i] - prefix[i] - 1));
        }

        return output;
    }
}