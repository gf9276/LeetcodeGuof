package com.guof.string.implement_str_str;

/**
 * ClassName: Test
 * Package: com.feng.string.implement_str_str
 * Description:
 *
 * @Author guof
 * @Create 2023/3/24 16:20
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solu = new Solution();

        String haystack = "leetcode";

        String needle = "leeto";

        System.out.println(solu.strStr(haystack, needle));

    }
}
