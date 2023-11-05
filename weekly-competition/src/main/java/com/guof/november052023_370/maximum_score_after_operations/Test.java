package com.guof.november052023_370.maximum_score_after_operations;

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
//        [[0,1],[0,2],[0,3],[2,4],[4,5]]
//        [5,2,5,2,1,1]
//        [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
//        [20,10,9,7,4,3,5]
//        [[7,0],[3,1],[6,2],[4,3],[4,5],[4,6],[4,7]]
//        [2,16,23,17,22,21,8,6]
        Solution solution = new Solution();
        int[][] edges = {{7, 0}, {3, 1}, {6, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 7}};
        int[] values = {2, 16, 23, 17, 22, 21, 8, 6}; // 113
        solution.maximumScoreAfterOperations(edges, values);
    }
}
