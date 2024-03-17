package com.guof.minimum_height_tree;


import java.util.*;

class Solution {
    List<Integer>[] lists;

    Set<Integer> set;

    List<Integer> output;

    int[] degree;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return new ArrayList<>(List.of(new Integer[]{0}));
        }

        // bfs, 答案就是中间那一层
        output = new ArrayList<>();

        degree = new int[n];

        lists = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
            ++degree[edge[0]];
            ++degree[edge[1]];
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            output.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                output.add(curNode);
                for (int nextNode : lists[curNode]) {
                    --degree[nextNode];
                    if (degree[nextNode] == 1) {
                        queue.add(nextNode);
                    }
                }
            }
        }

        return output;
    }
}