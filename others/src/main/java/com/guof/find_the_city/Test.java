package com.guof.find_the_city;

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
        int[][] input = {{3, 5, 9558}, {1, 2, 1079}, {1, 3, 8040}, {0, 1, 9258}, {4, 7, 7558}, {5, 6, 8196}, {3, 4, 7284}, {1, 5, 6327}, {0, 4, 5966}, {3, 6, 8575}, {2, 5, 8604}, {1, 7, 7782}, {4, 6, 2857}, {3, 7, 2336}, {0, 6, 6}, {5, 7, 2870}, {4, 5, 5055}, {0, 7, 2904}, {1, 6, 2458}, {0, 5, 3399}, {6, 7, 2202}, {0, 2, 3996}, {0, 3, 7495}, {1, 4, 2262}, {2, 6, 1390}};
        Solution solution = new Solution();
        solution.findTheCity(8, input, 7937);
    }
}
