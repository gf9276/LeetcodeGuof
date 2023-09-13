package com.feng.dynamic_programming.different_paths;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.different_paths
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 17:07
 * @Version 1.0
 */
//class Solution {
//    public int uniquePaths(int m, int n) {
//
//        int[][] dp = new int[m][n];
//
//        dp[0][0] = 0;
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }
//}

class Solution {
    public int uniquePaths(int m, int n) {
        // dfs和dp感觉都可以，用dp试试先
        // 到达一个点的方法，等同于左边加上边，呵呵
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

//class Solution {
//    int nbr = 0;
//
//    public int uniquePaths(int m, int n) {
//        // dfs和dp感觉都可以，用dfs试试
//        dfs(m, n, 0, 0);
//        return nbr;
//    }
//
//    public void dfs(int m, int n, int row, int col) {
//        if (row >= m) {
//            return;
//        } else if (col >= n) {
//            return;
//        }
//        if (row == m - 1 && col == n - 1) {
//            nbr++;
//            return;
//        }
//        dfs(m, n, row + 1, col);
//        dfs(m, n, row, col + 1);
//    }
//}