package com.feng.arrays_and_strings.longest_substring_without_repeating_characters;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.longest_substring_without_repeating_characters
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 20:23
 * @Version 1.0
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[255];
        int max_len = 0, j = 0; // j表示不含有重复字符的子串的第一个字符下标
        for (int i = 0; i < s.length(); i++) {
            int cInt = s.charAt(i);
            while (seen[cInt]) {
                // 如果没有重复，执行循环，j停的加，直到找到第一个重复的字符，其实前面加个j=i，效果一样的
                seen[s.charAt(j)] = false;
                ++j;
            }
            seen[cInt] = true; // 将字符标记为已经访问过了
            max_len = Math.max(max_len, i - j + 1); // i为什么比j大？
        }
        return max_len;
    }
}