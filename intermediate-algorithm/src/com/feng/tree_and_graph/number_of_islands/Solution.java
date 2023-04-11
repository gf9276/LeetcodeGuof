package com.feng.tree_and_graph.number_of_islands;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.number_of_islands
 * Description:
 *
 * @Author guof
 * @Create 2023/4/7 20:31
 * @Version 1.0
 */
class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int i, int j) {
        // 判断边界条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // 当前格子变成0
        // 上下左右调用一遍。
        dfs(grid, i - 1, j);//上
        dfs(grid, i + 1, j);//下
        dfs(grid, i, j + 1);//左
        dfs(grid, i, j - 1);//右
    }
}