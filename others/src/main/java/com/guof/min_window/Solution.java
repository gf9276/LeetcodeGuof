package com.guof.min_window;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        String output = "";
        // 双指针啊
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1); // 差的内容
        }
        int left = 0;
        int right = 0;
        int reserveNbr = map.size();
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                int curNbr = map.get(rightChar);
                map.put(rightChar, curNbr - 1);
                if (curNbr - 1 == 0) {
                    reserveNbr--; // 缺失的字母少了一个，当 reserveNbr 等于0的时候，完美cover
                }
                // 开始收缩左侧
                for (char leftChar = s.charAt(left);
                     !map.containsKey(leftChar) || map.get(leftChar) < 0;
                     left++, leftChar = s.charAt(left)) {
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                    }
                }

                // 当字符串完美cover的时候，尝试更新输出
                if (reserveNbr == 0 && (output.isEmpty() || output.length() > right - left + 1)) {
                    output = s.substring(left, right + 1);
                }
            }
            right++;
        }
        return output;
    }
}