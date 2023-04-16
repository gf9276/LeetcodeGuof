package com.feng.backtracking_algorithm.word_search;

/**
 * ClassName: Solution
 * Package: com.feng.backtracking_algorithm.word_search
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 15:37
 * @Version 1.0
 */
class Solution {
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray(); // 用这个，才不会超时
        result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, words, 0, i, j);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public void backtrack(char[][] board, char[] words, int now_idx, int i, int j) {
        if (result) {
            // 如果已经找到了，直接返回
            return;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0') {
            // 边界判断
            return;
        } else if (now_idx == words.length) {
            // 长度超出，返回
            return;
        }

        if (words[now_idx] == board[i][j]) {
            if (now_idx == words.length - 1) {
                result = true;
            } else {
                char tmpChar = board[i][j];
                board[i][j] = '0';
                backtrack(board, words, now_idx + 1, i - 1, j);//上

                backtrack(board, words, now_idx + 1, i + 1, j);//上

                backtrack(board, words, now_idx + 1, i, j + 1);//上

                backtrack(board, words, now_idx + 1, i, j - 1);//上
                board[i][j] = tmpChar;
            }
        }
    }
}