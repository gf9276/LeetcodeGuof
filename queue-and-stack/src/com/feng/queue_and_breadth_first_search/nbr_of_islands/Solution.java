package com.feng.queue_and_breadth_first_search.nbr_of_islands;


class Solution {
    public int numIslands(char[][] grid) {

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    set_zero(i, j, grid);
                }

            }
        }
        return num;

    }

    public void set_zero(int i, int j, char[][] grid) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) return;
        if (grid[i][j] == '1') {
            grid[i][j] = 0;
            set_zero(i - 1, j, grid);
            set_zero(i + 1, j, grid);
            set_zero(i, j - 1, grid);
            set_zero(i, j + 1, grid);
        }
    }
}