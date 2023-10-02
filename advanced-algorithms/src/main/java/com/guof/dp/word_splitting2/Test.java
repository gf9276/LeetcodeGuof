package com.guof.dp.word_splitting2;


import java.util.Arrays;

/**
 * ClassName: Test
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:14
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wordBreak("catsanddog",
                Arrays.asList("cats", "dog", "sand", "and", "cat"));
    }
}
