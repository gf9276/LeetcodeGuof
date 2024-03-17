package com.guof.minimum_height_tree;

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
        int[][] input = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        solution.findMinHeightTrees(6, input);

    }
}
