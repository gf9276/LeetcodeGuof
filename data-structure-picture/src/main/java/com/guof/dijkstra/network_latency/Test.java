package com.guof.dijkstra.network_latency;

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
        int[][] input = {{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
        solution.networkDelayTime(input, 5, 3);
    }
}
