package com.feng.arrays_and_strings.longest_palindromic_substring;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.longest_palindromic_substring
 * Description:
 *
 * @Author guof
 * @Create 2023/4/5 20:16
 * @Version 1.0
 */
class Solution {
    public String longestPalindrome(String s) {
        int max_length = 0;
        String output = "";
        int left, right;

        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;

            while (++right < s.length() && s.charAt(right) == s.charAt(left)) {
            }
            right--;
            while (--left >= 0 && s.charAt(right) == s.charAt(left)) {
            }
            left++;


            while (true) {
                right++;
                left--;
                if (!(left >= 0 && right < s.length()) || !(s.charAt(right) == s.charAt(left))) {
                    left++;
                    right--;
                    break;
                }
            }


            if (max_length < right - left + 1) {
                max_length = right - left + 1;
                output = s.substring(left, right + 1);
            }

        }

        return output;
    }
}