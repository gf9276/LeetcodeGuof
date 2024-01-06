package com.guof.cmp_2024_01_06_121.minimum_operations_to_make_equal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) {
            // 只能一个个加上去了
            return y - x;
        }

        if (x - y <= 5) {
            int[] output = new int[3];
            output[0] = x - y;

            // 向上补5
            int curNum = x;
            while (curNum % 5 != 0) {
                curNum++;
            }
            output[1] = minimumOperationsToMakeEqual(curNum / 5, y) + curNum - x + 1;

            // 向下补5
            curNum = x;
            if (curNum < 5) {
                output[2] = x - y;
            } else {
                while (curNum % 5 != 0) {
                    curNum--;
                }
                output[2] = minimumOperationsToMakeEqual(curNum / 5, y) + x - curNum + 1;
            }

            Arrays.sort(output);
            return Math.min(output[0], x - y);
        }

        int[] output = new int[4];

        // 向上补11
        int curNum = x;
        while (curNum % 11 != 0) {
            curNum++;
        }
        output[0] = minimumOperationsToMakeEqual(curNum / 11, y) + curNum - x + 1;

        // 向下补11
        curNum = x;
        if (curNum < 11) {
            output[1] = x - y;
        } else {
            while (curNum % 11 != 0) {
                curNum--;
            }
            output[1] = minimumOperationsToMakeEqual(curNum / 11, y) + x - curNum + 1;
        }

        // 向上补5
        curNum = x;
        while (curNum % 5 != 0) {
            curNum++;
        }
        output[2] = minimumOperationsToMakeEqual(curNum / 5, y) + curNum - x + 1;

        // 向下补5
        curNum = x;
        if (curNum < 5) {
            output[3] = x - y;
        } else {
            while (curNum % 5 != 0) {
                curNum--;
            }
            output[3] = minimumOperationsToMakeEqual(curNum / 5, y) + x - curNum + 1;
        }

        Arrays.sort(output);
        return Math.min(output[0], x - y);
    }
}