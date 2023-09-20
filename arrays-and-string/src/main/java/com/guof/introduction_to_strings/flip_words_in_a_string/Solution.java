package com.guof.introduction_to_strings.flip_words_in_a_string;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 其实有更好的方法
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public String reverseWords(String s) {
        String[] result = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = result.length - 1; i >= 0; i--) {
            String item = result[i];
            if (!item.isEmpty()) {
                sb.append(item).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}