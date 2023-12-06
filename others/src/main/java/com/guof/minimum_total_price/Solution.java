package com.guof.minimum_total_price;


import java.util.*;

class Solution {
    int[] allPrice;
    int[] price;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        allPrice = new int[n];
        this.price = price;

        // 邻接矩阵
        boolean[][] matrix = new boolean[n][n];
        for (int[] edge : edges) {
            // 两者相接
            matrix[edge[0]][edge[1]] = true;
            matrix[edge[1]][edge[0]] = true;
        }

        for (int[] trip : trips) {
            dfs(matrix, trip[0], trip[1], new ArrayList<>());
        }

        // 相邻的点不能减半，所以是减半还是不减半呢
        int sum = Arrays.stream(allPrice).sum();
        int[] tmp = dfs2(matrix, 0, -1);
        return sum - Math.max(tmp[0], tmp[1]);
    }

    /**
     * 没有成环，应该是有且仅有一条路
     *
     * @param matrix
     * @param curPoint
     * @param end
     */
    public void dfs(boolean[][] matrix, int curPoint, int end, List<Integer> paths) {
        paths.add(curPoint);
        if (curPoint == end) {
            // 抵达终点了
            for (Integer point : paths) {
                allPrice[point] += price[point];
            }
        }
        for (int i = 0; i < matrix[curPoint].length; i++) {
            if (matrix[curPoint][i]) {
                // 切断连接
                matrix[i][curPoint] = false;
                matrix[curPoint][i] = false;

                dfs(matrix, i, end, paths);

                // 恢复连接
                matrix[i][curPoint] = true;
                matrix[curPoint][i] = true;
            }
        }
        paths.remove(paths.size() - 1);
    }

    public int[] dfs2(boolean[][] matrix, int curPoint, int lastPoint) {
        // 计算最大和
        int hasSteal = allPrice[curPoint] / 2;
        int noSteal = 0;
        for (int i = 0; i < matrix[curPoint].length; i++) {
            if (i == lastPoint) {
                // 避免重复
                continue;
            }
            if (matrix[curPoint][i]) {
                int[] tmp = dfs2(matrix, i, curPoint);
                noSteal += Math.max(tmp[0], tmp[1]);
                hasSteal += tmp[0];
            }
        }
        return new int[]{noSteal, hasSteal};
    }
}