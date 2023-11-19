package com.guof.find_circle_num;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] rank;
    int[] root;

    int find(int x) {
        if (x == root[x]) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else {
            rank[rootA]++;
            root[rootB] = rootA;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        rank = new int[isConnected.length];
        root = new int[isConnected.length];
        Arrays.fill(rank, 1);
        for (int i = 0; i < isConnected.length; i++) {
            root[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }
}