package com.guof.count_pairs;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countPairs(int n, int[][] edges) {
        // 图啊，并查集试试？
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> map = new HashMap<>(); // 统计区间数量
        for (int i = 0; i < n; i++) {
            map.put(unionFind.find(i), map.getOrDefault(unionFind.find(i), 0) + 1);
        }

        long output = (long) n * (n - 1) / 2;
        for (int key : map.keySet()) {
            output -= (long) map.get(key) * (map.get(key) - 1) / 2;
        }

        return output;
    }

    static class UnionFind {
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
            if (rank[a] > rank[b]) {
                root[b] = a;
            } else if (rank[a] < rank[b]) {
                root[a] = b;
            } else {
                root[b] = a;
                rank[a]++;
            }
        }

        public boolean connect(int a, int b) {
            return find(a) == find(b);
        }
    }

}