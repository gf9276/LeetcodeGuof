package com.feng.string.longest_common_prefix;

/**
 * ClassName: Test
 * Package: com.feng.string.longest_common_prefix
 * Description:
 *
 * @Author guof
 * @Create 2023/3/24 18:31
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solu = new Solution();

        String[] str = {"flower", "flow", "flight"};

        String common_prefix = solu.longestCommonPrefix(str);

        System.out.println(common_prefix);

    }
}
