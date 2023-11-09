package com.guof.can_change;

class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        for (; i < start.length(); i++) {
            if (start.charAt(i) == '_') {
                continue;
            }
            if (j == target.length()) {
                return false; // 找不到对应的j了，不是false是什么？
            }
            while (target.charAt(j) == '_') {
                j++;
                if (j == target.length()) {
                    return false; // 找不到对应的j了，不是false是什么？
                }
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false; // 这是不可能的，因为前面的replace已经对这种情况做了修正，我只是写在这里而已
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            j++;
        }
        for (int curJ = j; curJ < target.length(); curJ++) {
            if (target.charAt(curJ) != '_') {
                return false;
            }
        }
        return true;
    }
}