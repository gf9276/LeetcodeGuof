package com.guof.practical_application_hash_mapping.the_longest_substring_containing_at_most_two_different_characters;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int slow = 0;
        int fast = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxSize = 0;

        while (fast < s.length()) {
            if (map.containsKey(s.charAt(fast))) {
                map.put(s.charAt(fast), map.get(s.charAt(fast)) + 1);
            } else {
                map.put(s.charAt(fast), 1);
            }

            if (map.keySet().size() <= 2) {
                int tmp = 0;
                for (Character key : map.keySet()) {
                    tmp += map.get(key);
                }
                maxSize = Math.max(maxSize, tmp);
            }
            while (fast - slow + 1 > maxSize) {
                int tmp = map.get(s.charAt(slow)) - 1;
                if (tmp == 0) {
                    map.remove(s.charAt(slow));
                } else {
                    map.put(s.charAt(slow), tmp);
                }
                slow++;
            }
            fast++;
        }
        return maxSize;
    }
}