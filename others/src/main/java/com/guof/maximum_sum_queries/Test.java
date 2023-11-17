package com.guof.maximum_sum_queries;

/**
 * ClassName: Test
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 19:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intput = {{4, 1}, {1, 3}, {2, 5}};
        solution.maximumSumQueries(new int[]{4, 3, 1, 2}, new int[]{2, 4, 9, 5}, intput);
    }
}
