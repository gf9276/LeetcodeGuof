package com.guof.tree_and_graph.the_longest_incremental_path_in_a_matrix;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int output = Integer.MIN_VALUE;
        int[][] lengthMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (lengthMatrix[i][j] == 0) {
                    output = Math.max(output, dfs(matrix, lengthMatrix, i, j));
                }
            }
        }
        return output;
    }


    public int dfs(int[][] matrix, int[][] lengthMatrix, int x, int y) {
        // 笑死我了，找递减路径不就好了？
        if (lengthMatrix[x][y] != 0) {
            // 如果下面的路已经走过了，直接返回以前的长度
            return lengthMatrix[x][y];
        }


        int tmp = 0;

        // 递减的路，四个方向是试一试，获取最长的
        if (!crossTheBorder(matrix, x + 1, y) && matrix[x + 1][y] < matrix[x][y]) {
            tmp = Math.max(tmp, dfs(matrix, lengthMatrix, x + 1, y));
        }
        if (!crossTheBorder(matrix, x, y + 1) && matrix[x][y + 1] < matrix[x][y]) {
            tmp = Math.max(tmp, dfs(matrix, lengthMatrix, x, y + 1));
        }
        if (!crossTheBorder(matrix, x - 1, y) && matrix[x - 1][y] < matrix[x][y]) {
            tmp = Math.max(tmp, dfs(matrix, lengthMatrix, x - 1, y));
        }
        if (!crossTheBorder(matrix, x, y - 1) && matrix[x][y - 1] < matrix[x][y]) {
            tmp = Math.max(tmp, dfs(matrix, lengthMatrix, x, y - 1));
        }

        lengthMatrix[x][y] = 1 + tmp;
        return lengthMatrix[x][y];
    }

    public boolean crossTheBorder(int[][] matrix, int x, int y) {
        return x > matrix.length - 1 || x < 0 || y > matrix[0].length - 1 || y < 0;
    }
}