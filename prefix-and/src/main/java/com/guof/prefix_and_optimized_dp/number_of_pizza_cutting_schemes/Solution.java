package com.guof.prefix_and_optimized_dp.number_of_pizza_cutting_schemes;

class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[m - 1].length();

        int[][] applePrefix = getApplePrefix(pizza);

        int[][][] dp = new int[m][n][k]; // 以 i j 为坐上脚，m n 为右下角，切 ？ 次 有 至少 ？ 个苹果的情况数
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (getAppleNbr(applePrefix, i, j, m - 1, n - 1) > 0) {
                    dp[i][j][0] = 1; // 如果苹果数大于0，有一种不用切的方法。换句话说，我不认为没有苹果的披萨还需要多来一刀
                }
            }
        }


        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 获取当前披萨的苹果数量
                int curAppleNbr = getAppleNbr(applePrefix, i, j, m - 1, n - 1);

                // 最多只需要切curAppleNbr-1刀，就可以分出curAppleNbr个苹果
                for (int l = 1; l <= Math.min(k, curAppleNbr) - 1; l++) {
                    for (int t = i + 1; t < m; t++) {
                        // 横切
                        int lowNbr = getAppleNbr(applePrefix, t, j, m - 1, n - 1);
                        int upNbr = curAppleNbr - lowNbr;
                        if (upNbr >= 1 && lowNbr >= l) {
                            dp[i][j][l] += dp[t][j][l - 1];
                            dp[i][j][l] %= 1000000007;
                        }
                    }
                    for (int t = j + 1; t < n; t++) {
                        // 竖切
                        int rightNbr = getAppleNbr(applePrefix, i, t, m - 1, n - 1);
                        int leftNbr = curAppleNbr - rightNbr;
                        if (leftNbr >= 1 && rightNbr >= l) {
                            dp[i][j][l] += dp[i][t][l - 1];
                            dp[i][j][l] %= 1000000007;
                        }
                    }

                }

            }
        }
        return dp[0][0][k - 1];

    }


    public int[][] getApplePrefix(String[] pizza) {
        int m = pizza.length;
        int n = pizza[m - 1].length();
        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] += pizza[i].charAt(j) == 'A' ? 1 : 0;
                if (j - 1 >= 0) {
                    prefix[i][j] += prefix[i][j - 1];
                }
                if (i - 1 >= 0) {
                    prefix[i][j] += prefix[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                }
            }
        }
        return prefix;
    }

    public int getAppleNbr(int[][] prefix, int row1, int col1, int row2, int col2) {
        int output = prefix[row2][col2];

        if (row1 - 1 >= 0) {
            output -= prefix[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            output -= prefix[row2][col1 - 1];
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            output += prefix[row1 - 1][col1 - 1];
        }
        return output;
    }
}