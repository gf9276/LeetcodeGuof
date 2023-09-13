package com.feng.backtracking_algorithm.word_search;

/**
 * ClassName: Test
 * Package: com.feng.backtracking_algorithm.word_search
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 15:55
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[3][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';

        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';

        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';

        solution.exist(board,"SEE");

    }
}


