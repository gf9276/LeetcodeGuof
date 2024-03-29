package com.guof.pacific_atlantic;


import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> output = new ArrayList<>();
        // 找条出路罢了，如果该点大于等于四周的点，并且四周的点可以溜出去，那么该点显然也可以流出去
        // 用dfs，找一条出路嘛
        boolean[][][] allowOutflow = new boolean[heights.length][heights[0].length][2];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                dfs(heights, i, j, new ArrayList<>(), allowOutflow);
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (allowOutflow[i][j][0] & allowOutflow[i][j][1]) {
                    output.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return output;
    }


    public void dfs(int[][] height, int curX, int curY, List<int[]> pathList, boolean[][][] allowOutflow) {
        if (allowOutflow[curX][curY][0] & allowOutflow[curX][curY][1]) {
            // 没搞的必要了，一路通行
            for (int[] point : pathList) {
                allowOutflow[point[0]][point[1]][0] = true; // 遇到PA了
                allowOutflow[point[0]][point[1]][1] = true; // 遇到PA了
            }
            allowOutflow[curX][curY][1] = true;
            allowOutflow[curX][curY][0] = true;
            return;
        }

        if (curX == height.length - 1 || curY == height[0].length - 1) {
            // 遇到边界了
            for (int[] point : pathList) {
                allowOutflow[point[0]][point[1]][1] = true; // 遇到AL了
            }
            allowOutflow[curX][curY][1] = true;
        }
        if (curX == 0 || curY == 0) {
            for (int[] point : pathList) {
                allowOutflow[point[0]][point[1]][0] = true; // 遇到PA了
            }
            allowOutflow[curX][curY][0] = true;
        }

        if (curX + 1 < height.length && height[curX + 1][curY] <= height[curX][curY]) {
            // 如果比他高，不能走走过的路
            pathList.add(new int[]{curX, curY});
            int tmp = height[curX][curY];
            height[curX][curY] = Integer.MAX_VALUE;
            dfs(height, curX + 1, curY, pathList, allowOutflow);
            pathList.remove(pathList.size() - 1);
            height[curX][curY] = tmp;
        }
        if (curX - 1 >= 0 && height[curX - 1][curY] <= height[curX][curY]) {
            // 如果比他高
            pathList.add(new int[]{curX, curY});
            int tmp = height[curX][curY];
            height[curX][curY] = Integer.MAX_VALUE;
            dfs(height, curX - 1, curY, pathList, allowOutflow);
            pathList.remove(pathList.size() - 1);
            height[curX][curY] = tmp;
        }
        if (curY + 1 < height[curX].length && height[curX][curY + 1] <= height[curX][curY]) {
            // 如果比他高
            pathList.add(new int[]{curX, curY});
            int tmp = height[curX][curY];
            height[curX][curY] = Integer.MAX_VALUE;
            dfs(height, curX, curY + 1, pathList, allowOutflow);
            pathList.remove(pathList.size() - 1);
            height[curX][curY] = tmp;
        }
        if (curY - 1 >= 0 && height[curX][curY - 1] <= height[curX][curY]) {
            // 如果比他高
            pathList.add(new int[]{curX, curY});
            int tmp = height[curX][curY];
            height[curX][curY] = Integer.MAX_VALUE;
            dfs(height, curX, curY - 1, pathList, allowOutflow);
            pathList.remove(pathList.size() - 1);
            height[curX][curY] = tmp;
        }
    }
}