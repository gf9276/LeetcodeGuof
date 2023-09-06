package com.feng.practical_application_hash_mapping.the_longest_repeated_character_after_replacement;


class Solution {
    public int characterReplacement(String s, int k) {
        int slow = 0;
        int fast = 0;
        int[] cnt = new int[26];
        int maxTime = 0;

        while (fast < s.length()) {
            cnt[s.charAt(fast) - 'A']++;
            maxTime = Math.max(maxTime, cnt[s.charAt(fast) - 'A']);
            if (fast - slow + 1 - maxTime > k) {
                cnt[s.charAt(slow) - 'A']--;
                slow++;
            }
            fast++;
        }
        return fast - slow;
    }
}