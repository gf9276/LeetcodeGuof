package com.guof.maximum_minutes;

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
        int[][] input = {{0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 1, 0}, {0, 2, 0, 0, 1, 2, 0}, {0, 0, 2, 2, 2, 0, 2}, {0, 0, 0, 0, 0, 0, 0}};
        Solution solution = new Solution();
        solution.maximumMinutes(input);
        System.out.println();
    }
}
