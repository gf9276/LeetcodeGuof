package com.guof.union_find.number_of_provinces;

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

        int[][] input = new int[3][3];
        input[0] = new int[]{1, 1, 0};
        input[1] = new int[]{1, 1, 0};
        input[2] = new int[]{0, 0, 1};

        System.out.println(solution.findCircleNum(input));
    }
}
