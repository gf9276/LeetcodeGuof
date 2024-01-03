package com.guof.maximum_rows;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] newMatrix;
    int output = 0;
    int m;
    int n;

    public int maximumRows(int[][] matrix, int numSelect) {
        // 从 n 中挑选 num 个，使得结果最优
        // 感觉直接遍历也可以啊哈哈
        m = matrix.length;
        n = matrix[0].length;

        newMatrix = new int[m]; // 二值化，方便计算
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i] = (newMatrix[i] << 1) | matrix[i][j];
            }
        }

        dfs(numSelect - 1, 1);

        return output;
    }

    void dfs(int numSelect, int curNum) {
        if (output == m) {
            // 全满了，无敌了
            return;
        }
        if (curNum >= (1 << n)) {
            // 太大了
            return;
        }
        if (numSelect == 0) {
            // 机会用完了
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (((~curNum) & newMatrix[i]) == 0) {
                    // 这是我推出来的
                    sum++;
                }
            }
            output = Math.max(output, sum);
        }
        dfs(numSelect, curNum << 1);
        dfs(numSelect - 1, (curNum << 1) + 1);
    }
}