package com.guof.tree_and_graph.surrounded_area;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    List<Integer[]> coordList = new ArrayList<>();
                    boolean close = dfs(board, i, j, coordList);
                    if (close) {
                        for (Integer[] coord : coordList) {
                            board[coord[0]][coord[1]] = 'X';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public boolean dfs(char[][] board, int x, int y, List<Integer[]> coordList) {
        if (x > board.length - 1 || x < 0 || y > board[0].length - 1 || y < 0) {
            return false; // 寄了
        }
        // 返回是的true，说明没有碰到，直接吧coordList里的变成X就行
        // 要是false，直接就是Q，等着最后一起变成'O'
        if (board[x][y] == 'X' || board[x][y] == 'Q') {
            // 碰到边界了，或者碰到走过的路了
            return true;
        }
        board[x][y] = 'Q';
        coordList.add(new Integer[]{x, y});

        boolean close = true;
        // 下右上左
        close &= dfs(board, x + 1, y, coordList);
        close &= dfs(board, x, y + 1, coordList);
        close &= dfs(board, x - 1, y, coordList);
        close &= dfs(board, x, y - 1, coordList);

        return close;
    }

}