package com.guof.nshaped_transformation;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 像是模拟题
        List<Character>[] lists = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            lists[i] = new ArrayList<>();
        }

        int curRow = 0;
        int direction = 1;
        for (char c : s.toCharArray()) {
            lists[curRow].add(c);
            if (curRow + direction == numRows) {
                direction = -1;
            } else if (curRow + direction == -1) {
                direction = 1;
            }
            curRow += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < lists[i].size(); j++) {
                sb.append(lists[i].get(j));
            }
        }
        return sb.toString();
    }
}