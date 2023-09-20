package com.guof.double_index_technique_colliding_pointers.reverse_vowels;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.double_index_technique_colliding_pointers.reverse_vowels
 * Description:
 *
 * @Author guof
 * @Create 2023/5/16 12:37
 * @Version 1.0
 */
class Solution {
    public String reverseVowels(String s) {
        int left_p = 0;
        int right_p = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left_p < right_p) {

            if (isVowels(chars[left_p]) && isVowels(chars[right_p])) {
                // 交换位置
                char tmp = chars[left_p];
                chars[left_p] = chars[right_p];
                chars[right_p] = tmp;
                left_p++;
                right_p--;
            }

            if (!isVowels(chars[left_p])) {
                left_p++;
            }
            if (!isVowels(chars[right_p])) {
                right_p--;
            }
        }
        return String.valueOf(chars);
    }

    boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}