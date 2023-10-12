package com.guof.possible_bipartition;


import java.util.Arrays;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 并查集，从0开始算的，数量是2*n个
        UnionFind unionFind = new UnionFind(2 * n);
        for (int[] dislike : dislikes) {
            int a = dislike[0] - 1;
            int b = dislike[1] - 1;
            if (unionFind.connect(a, b)) {
                return false;
            }
            unionFind.union(a, b + n);
            unionFind.union(b, a + n);
        }
        return true;
    }

    static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
            rank = new int[size];
            Arrays.fill(rank, 1);
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) {
                return;
            }

            if (rank[a] < rank[b]) {
                root[a] = b;
            } else if (rank[a] > rank[b]) {
                root[b] = a;
            } else {
                rank[a]++;
                root[b] = a;
            }
        }

        public boolean connect(int a, int b) {
            return find(a) == find(b);
        }

    }
}