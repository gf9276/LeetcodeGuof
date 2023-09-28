package com.guof.arrays_and_strings.game_of_life;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oneNbr = getOneNbr(board, i, j);
                if (board[i][j] == 1 && oneNbr < 2) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && oneNbr > 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && oneNbr == 3) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int getOneNbr(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int output = 0;


        // 最上面那一行
        if (x - 1 >= 0) {
            for (int i = Math.max(0, y - 1); i <= Math.min(y + 1, n - 1); i++) {
                if (board[x - 1][i] == 1 || board[x - 1][i] == 2) {
                    output += 1;
                }
            }
        }

        // 右边那一列
        if (y + 1 <= n - 1) {
            for (int i = x; i <= Math.min(m - 1, x + 1); i++) {
                if (board[i][y + 1] == 1 || board[i][y + 1] == 2) {
                    output += 1;
                }
            }
        }

        // 下边那一行
        if (x + 1 <= m - 1) {
            for (int i = y; i >= Math.max(0, y - 1); i--) {
                if (board[x + 1][i] == 1 || board[x + 1][i] == 2) {
                    output += 1;
                }
            }
        }

        // 左边那一列
        if (y - 1 >= 0) {
            if (board[x][y - 1] == 1 || board[x][y - 1] == 2) {
                output += 1;
            }
        }

        return output;
    }

}