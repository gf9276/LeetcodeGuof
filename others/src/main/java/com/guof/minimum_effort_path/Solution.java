package com.guof.minimum_effort_path;


import java.util.*;

class Solution {
    int[] root;
    int[] rank;


    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        root = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(rank, 0);
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        List<int[]> lists = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i < m - 1) {
                    lists.add(new int[]{n * i + j, n * (i + 1) + j, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
                if (j < n - 1) {
                    lists.add(new int[]{n * i + j, n * i + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                }
            }
        }
        lists.sort(Comparator.comparingInt(a -> a[2]));
        for (int[] tmp : lists) {
            union(tmp[0], tmp[1]);
            if (connected(0, m * n - 1)) {
                return tmp[2];
            }
        }
        return 0;
    }


    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] == rank[rootB]) {
            rank[rootA]++;
            root[rootB] = rootA;
        } else if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else {
            root[rootA] = rootB;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}