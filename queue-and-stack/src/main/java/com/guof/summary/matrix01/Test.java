package com.guof.summary.matrix01;


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

        Solution solo = new Solution();

        int[][] mat = new int[3][3];
        mat[0][0] = 0;
        mat[0][1] = 0;
        mat[0][2] = 0;
        mat[1][0] = 0;
        mat[1][1] = 1;
        mat[1][2] = 0;
        mat[2][0] = 0;
        mat[2][1] = 0;
        mat[2][2] = 0;

        solo.updateMatrix(mat);


    }
}
