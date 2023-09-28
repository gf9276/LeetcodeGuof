package com.guof.arrays_and_strings.min_covering_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        String output = "";
        int left = 0;
        int right = 0;
        for (; right < s.length(); right++) {
            map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);
            boolean cover = map1CoverMap2(map1, map2);
            if (cover) {
                output = s.substring(left, right + 1);
                minLen = right + 1 - left;
                break;
            }
        }

        if (right == s.length()) {
            return output;
        }

        // 开始滑动
        boolean cover = true;
        Character lack = null;
        while (true) {
            if (cover) {
                if (right + 1 - left < minLen) {
                    output = s.substring(left, right + 1);
                    minLen = right + 1 - left;
                }
                int curNbr = map1.get(s.charAt(left));
                curNbr--;
                if (curNbr == 0) {
                    map1.remove(s.charAt(left));
                } else {
                    map1.put(s.charAt(left), curNbr);
                }
                if (map2.getOrDefault(s.charAt(left), 0) > curNbr) {
                    cover = false;
                    lack = s.charAt(left);
                }
                left++;
            } else {
                while (map1.getOrDefault(lack, 0) < map2.get(lack)) {
                    right++;
                    if (right >= s.length()) {
                        break;
                    }
                    map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);
                }
                if (right >= s.length()) {
                    break;
                }
                cover = true;
            }
        }
        return output;
    }

    public boolean map1CoverMap2(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() < map2.size()) {
            return false;
        }
        for (Character key : map2.keySet()) {
            if (map2.get(key) > map1.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}