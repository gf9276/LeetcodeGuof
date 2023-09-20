package com.guof.string.longest_common_prefix;

/**
 * ClassName: Solution
 * Package: com.feng.string.longest_common_prefix
 * Description:
 *
 * @Author guof
 * @Create 2023/3/24 18:31
 * @Version 1.0
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {

        String common_prefix = strs[0];  // 第一个是公共前缀

        for (int i = 1; i < strs.length; i++) {
            common_prefix = getCommonPrefix(common_prefix, strs[i]);
        }

        return common_prefix;
    }

    private String getCommonPrefix(String str1, String str2) {
        int end_idx = 0;
        for (int i = 0; ; i++) {
            if (i == str1.length() || i == str2.length() || str1.charAt(i) != str2.charAt(i)) {
                end_idx = i - 1;
                break;
            }
        }

        if (end_idx < 0) {
            return "";
        } else {
            return str1.substring(0, end_idx + 1);
        }
    }

}