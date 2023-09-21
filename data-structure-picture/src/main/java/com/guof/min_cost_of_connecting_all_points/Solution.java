package com.guof.min_cost_of_connecting_all_points;

import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        if (points.length == 2) {
            return getDist(points[0], points[1]);
        }

        Map<Integer[], Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                map.put(new Integer[]{i, j}, getDist(points[i], points[j]));
            }
        }

        List<Map.Entry<Integer[], Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        UnionFind unionFind = new UnionFind(points.length);
        int output = 0;
        for (Map.Entry<Integer[], Integer> entry : entryList) {
            Integer[] key = entry.getKey();
            Integer value = entry.getValue();
            if (!unionFind.connected(key[0], key[1])) {
                unionFind.union(key[0], key[1]);
                output += value;
            }
        }
        return output;
    }

    public int getDist(int[] point1, int[] point2) {
        return Math.abs(point1[1] - point2[1]) + Math.abs(point1[0] - point2[0]);
    }

    public class UnionFind {

        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
            Arrays.fill(rank, 1);
        }

        public void union(int a, int b) {
            // 连接两个点

            // 找到两个根节点
            int findA = find(a);
            int findB = find(b);

            if (findA == findB) {
                return;
            }

            if (rank[findA] > rank[findB]) {
                root[findB] = findA;
            } else if (rank[findA] < rank[findB]) {
                root[findA] = findB;
            } else {
                root[findB] = findA;
                rank[findA] += 1;
            }
        }

        public int find(int x) {
            // 要路径压缩一下
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
}