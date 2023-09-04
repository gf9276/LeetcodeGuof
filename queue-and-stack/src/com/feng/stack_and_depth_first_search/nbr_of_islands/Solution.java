package com.feng.stack_and_depth_first_search.nbr_of_islands;


class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int output = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    output++;
                    dfs(grid, i, j);
                }
            }

        }
        return output;
    }


    public void dfs(char[][] grid, int x, int y) {
        if (grid[x][y] != '1') return;

        // 按照顺序，上右下左
        grid[x][y] = 0;
        if (x - 1 > -1 && grid[x - 1][y] == '1') {
            dfs(grid, x - 1, y);
        }

        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            dfs(grid, x, y + 1);
        }

        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
            dfs(grid, x + 1, y);
        }

        if (y - 1 > -1 && grid[x][y - 1] == '1') {
            dfs(grid, x, y - 1);
        }
    }
}