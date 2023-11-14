package com.guof.find_the_city;


class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 计算每一个点到其他点的距离
        // 建立一个有向图吧，可能有其他的算法，不过我这样子应该没啥问题

        int[][] distMatrix = new int[n][n]; // 对角线肯定是0，然后由于是双向图，所以只用考虑上三角的说
        int inf = 0x3f3f3f3f;

        for (int i = 0; i < distMatrix.length; i++) {
            for (int j = 0; j < distMatrix[i].length; j++) {
                if (i == j) {
                    continue;
                }
                distMatrix[i][j] = inf;
            }
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int dist = edge[2];

            if (dist < distMatrix[start][end]) {
                distMatrix[start][end] = dist;
                distMatrix[end][start] = dist;
            }
        }
        floyd(distMatrix);
        int output = -1;
        int minNbr = inf;

        for (int i = 0; i < distMatrix.length; i++) {
            int curNbr = 0;
            for (int j = 0; j < distMatrix[i].length; j++) {
                if (distMatrix[i][j] <= distanceThreshold) {
                    curNbr++;
                }
                if (curNbr > minNbr) {
                    break;
                }
            }
            if (minNbr >= curNbr) {
                minNbr = curNbr;
                output = i;
            }
        }
        return output;
    }
    void floyd(int[][] g) {
        int n = g.length;
        // floyd 基本流程为三层循环: [枚举中转点 - 枚举起点 - 枚举终点] => 松弛操作
        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][p] + g[p][j]);
                }
            }
        }
    }
}