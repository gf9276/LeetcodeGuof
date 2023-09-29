package com.guof.tree_and_graph.nbr_of_provinces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            set.add(root);
        }

        return set.size();
    }

    class UnionFind {
        int[] rank;
        int[] arr;

        public UnionFind(int size) {
            rank = new int[size];
            Arrays.fill(rank, 1);
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
        }

        public int find(int x) {
            if (x == arr[x]) {
                return x;
            }
            arr[x] = find(arr[x]);
            return arr[x];
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return;
            }
            if (rank[a] > rank[b]) {
                arr[b] = a;
            } else if (rank[a] < rank[b]) {
                arr[a] = b;
            } else {
                arr[b] = a;
                rank[a]++;
            }

        }

        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }
}