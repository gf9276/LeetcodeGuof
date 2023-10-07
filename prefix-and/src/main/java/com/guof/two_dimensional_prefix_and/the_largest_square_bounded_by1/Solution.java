package com.guof.two_dimensional_prefix_and.the_largest_square_bounded_by1;


class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        // 0维表示横向，1表示纵向
        int[][][] dp = new int[grid.length][grid[0].length][2];

        // 计算行累计长度，计算列累计长度
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (j - 1 >= 0) {
                        dp[i][j][0] = dp[i][j - 1][0];
                    }
                    if (i - 1 >= 0) {
                        dp[i][j][1] = dp[i - 1][j][1];
                    }
                    dp[i][j][0] += 1;
                    dp[i][j][1] += 1;
                }
            }
        }

        int sideLength = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]); // 取小为边长

                if (sideLength >= curSide) {
                    // 这个边长不够，过
                    continue;
                }

                while (curSide > sideLength && (dp[i + 1 - curSide][j][0] < curSide || dp[i][j + 1 - curSide][1] < curSide)) {
                    curSide--;
                }
                sideLength = Math.max(sideLength, curSide);
            }
        }

        return sideLength * sideLength;
    }
}