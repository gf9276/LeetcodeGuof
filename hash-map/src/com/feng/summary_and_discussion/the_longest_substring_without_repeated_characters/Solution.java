package com.feng.summary_and_discussion.the_longest_substring_without_repeated_characters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[256];
        int maxLen = 0;
        int firstIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            while (seen[s.charAt(i)]) {
                seen[s.charAt(firstIdx)] = false;
                firstIdx++;
            }
            seen[s.charAt(i)] = true;
            maxLen = Math.max(maxLen, i - firstIdx + 1);
        }

        return maxLen;

    }
}