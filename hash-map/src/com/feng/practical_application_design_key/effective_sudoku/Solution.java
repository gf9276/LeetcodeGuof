package com.feng.practical_application_design_key.effective_sudoku;

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            Map<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                if (aChar <= '9' && aChar >= '0') {
                    if (map.containsKey(aChar)) {
                        return false;
                    } else {
                        map.put(aChar, 1);
                    }
                }
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            Map<Character, Integer> map = new HashMap<>();
            for (char[] chars : board) {
                if (chars[j] <= '9' && chars[j] >= '0') {
                    if (map.containsKey(chars[j])) {
                        return false;
                    } else {
                        map.put(chars[j], 1);
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Map<Character, Integer> map = new HashMap<>();
                for (int k = 0; k < 9; k++) {
                    if (board[3 * i + k / 3][3 * j + k % 3] <= '9' && board[3 * i + k / 3][3 * j + k % 3] >= '0') {
                        if (map.containsKey(board[3 * i + k / 3][3 * j + k % 3])) {
                            return false;
                        } else {
                            map.put(board[3 * i + k / 3][3 * j + k % 3], 1);
                        }
                    }
                }
            }
        }
        return true;
    }
}