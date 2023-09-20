package com.guof.backtracking_algorithm.word_search;

/**
 * ClassName: Solution
 * Package: com.feng.backtracking_algorithm.word_search
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 15:37
 * @Version 1.0
 */
//class Solution {
//    boolean result = false;
//
//    public boolean exist(char[][] board, String word) {
//        char[] words = word.toCharArray(); // 用这个，才不会超时
//        result = false;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                backtrack(board, words, 0, i, j);
//                if (result) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public void backtrack(char[][] board, char[] words, int now_idx, int i, int j) {
//        if (result) {
//            // 如果已经找到了，直接返回
//            return;
//        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0') {
//            // 边界判断
//            return;
//        } else if (now_idx == words.length) {
//            // 长度超出，返回
//            return;
//        }
//
//        if (words[now_idx] == board[i][j]) {
//            if (now_idx == words.length - 1) {
//                result = true;
//            } else {
//                char tmpChar = board[i][j];
//                board[i][j] = '0';
//                backtrack(board, words, now_idx + 1, i - 1, j);//上
//
//                backtrack(board, words, now_idx + 1, i + 1, j);//上
//
//                backtrack(board, words, now_idx + 1, i, j + 1);//上
//
//                backtrack(board, words, now_idx + 1, i, j - 1);//上
//                board[i][j] = tmpChar;
//            }
//        }
//    }
//}

class Solution {
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        // 这不就是孤岛+回溯？
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, word.toCharArray(), 0, i, j);
                if (result) return true;
            }
        }
        return result;
    }

    public void dfs(char[][] board, char[] word, int now_idx, int row, int col) {
        if (result || now_idx >= word.length || (row < 0 || row >= board.length || col < 0 || col >= board[0].length)) {
            // 边界判断 是否成功？是否达到长度？坐标是否超出边界？
            return;
        }
        else if (board[row][col] == 0 || board[row][col] != word[now_idx]) {
            // 当前字母是否访问过？当前字母是否是对的？
            return;
        }
        else if (now_idx == word.length - 1) {
            result = true;
            return;
        }

        char tmpChar = board[row][col];
        board[row][col] = 0;
        // dfs
        dfs(board, word, now_idx + 1, row + 1, col);
        dfs(board, word, now_idx + 1, row - 1, col);
        dfs(board, word, now_idx + 1, row, col + 1);
        dfs(board, word, now_idx + 1, row, col - 1);

        // 回溯
        board[row][col] = tmpChar;
    }
}