package com.guof.min_swaps_couples;


import java.util.Arrays;

class Solution {
    public int minSwapsCouples(int[] row) {
        int m = row.length;
        int n = m / 2; // n对情侣
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < m; i += 2) {
            // 把相邻的但是不是情侣的连起来
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }

        int output = n;
        for (int i = 0; i < n; i++) {
            if (i == unionFind.find(i)) {
                output--;
            }
        }

        return output;
    }


    class UnionFind {
        int[] rank;
        int[] root;

        public UnionFind(int size) {
            rank = new int[size];
            Arrays.fill(rank, 1); // 初始化高度为1
            root = new int[size];
            for (int i = 0; i < root.length; i++) {
                // 初始化自己的根是自己
                root[i] = i;
            }
        }

        public void union(int a, int b) {
            int rootA = find(a); // 找到对应的根
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootB] > rank[rootA]) {
                root[rootA] = rootB;
            } else {
                rank[rootA]++; // 高度加一再挂上去
                root[rootB] = rootA;
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
}