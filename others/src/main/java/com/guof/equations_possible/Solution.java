package com.guof.equations_possible;


import java.util.Arrays;

class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26); // 26个字母
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(equation.length() - 1) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (unionFind.connected(equation.charAt(0) - 'a', equation.charAt(equation.length() - 1) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    class UnionFind {
        int[] rank;
        int[] root;

        public UnionFind(int size) {
            rank = new int[size];
            root = new int[size];
            Arrays.fill(rank, 1);
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                rank[rootX]++;
                root[rootY] = rootX;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

    }
}