package com.guof.cmp_2024_03_02_125.count_pairs_of_connectable_servers;

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
//        int{}{} input = {{0, 6, 3}, {6, 5, 3}, {0, 3, 1}, {3, 2, 7}, {3, 1, 6}, {3, 4, 2}};
//        int{}{} input = {{0, 1, 1}, {1, 2, 5}, {2, 3, 13}, {3, 4, 9}, {4, 5, 2}};
        int[][] input = {{1, 0, 2}, {2, 1, 4}, {3, 2, 4}, {4, 0, 3}, {5, 1, 4}, {6, 2, 2}, {7, 6, 4}, {8, 1, 2}, {9, 8, 3}};
        solution.countPairsOfConnectableServers(input, 3);
    }
}
