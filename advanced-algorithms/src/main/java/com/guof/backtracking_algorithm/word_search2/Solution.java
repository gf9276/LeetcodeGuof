package com.guof.backtracking_algorithm.word_search2;

import java.util.*;

class Solution {
    List<String> output;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        // 这题就很垃了，有手就行
        output = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(new StringBuilder(), board, wordsSet, i, j);
            }
        }
        return output;
    }


    public void dfs(StringBuilder stringBuilder, char[][] board, Set<String> wordsSet, int x, int y) {
        if (stringBuilder.length() > 9) {
            // 我日了
            return;
        }
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            // 你逾越了，滚，哼哼
            return;
        }
        if (wordsSet.isEmpty()) {
            // 空都空了，还找什么呢
            return;
        }
        if (board[x][y] == 0) {
            // 你走过这条路了
            return;
        }

        // 判断是否成功+保存现场
        char curChar = board[x][y];
        stringBuilder.append(curChar);
        board[x][y] = 0;
        String curStr = stringBuilder.toString();
        if (wordsSet.contains(curStr)) {
            output.add(curStr);
            wordsSet.remove(curStr);
        }

        // 深层次遍历
        dfs(stringBuilder, board, wordsSet, x + 1, y);
        dfs(stringBuilder, board, wordsSet, x - 1, y);
        dfs(stringBuilder, board, wordsSet, x, y + 1);
        dfs(stringBuilder, board, wordsSet, x, y - 1);

        board[x][y] = curChar;
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
    }
}