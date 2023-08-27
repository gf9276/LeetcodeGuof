package feng.introduction_to_strings.longest_palindromic_substring;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 中心回文，简单粗暴~
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public String longestPalindrome(String s) {
        String output = s.substring(0, 1);
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right < c.length) {
                if (c[left] == c[right]) {
                    if (right + 1 - left > output.length()) {
                        output = s.substring(left, right + 1);
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }
        for (int i = 0; i < c.length; i++) {
            int left = i - 1;
            int right = i;

            while (left >= 0 && right < c.length) {
                if (c[left] == c[right]) {
                    if (right + 1 - left > output.length()) {
                        output = s.substring(left, right + 1);
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }
        return output;
    }
}