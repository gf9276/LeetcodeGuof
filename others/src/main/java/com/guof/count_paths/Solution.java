package com.guof.count_paths;


import java.util.*;

class Solution {
    private final static int MX = (int) 1e5;
    private final static boolean[] np = new boolean[MX + 1]; // 质数=false 非质数=true


    static {
        np[1] = true;
        for (int i = 2; i * i <= MX; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= MX; j += i) {
                    np[j] = true;
                }
            }
        }
    }


    public long countPaths(int n, int[][] edges) {
        List<Integer>[] newEdges = new List[n + 1];
        Arrays.setAll(newEdges, e -> new ArrayList<>());

        for (int[] edge : edges) {
            newEdges[edge[0]].add(edge[1]);
            newEdges[edge[1]].add(edge[0]);
        }

        long output = 0;
        Integer[] size = new Integer[n + 1];
        List<Integer> node = new ArrayList<>();
        for (int i = 1; i < newEdges.length; i++) {
            if (np[i]) continue;
            long sum = 0;
            for (Integer nextNode : newEdges[i]) {
                node.clear();
                if (!np[nextNode]) continue;

                if (size[nextNode] == null) {
                    dfs(node, newEdges, nextNode, -1);
                    size[nextNode] = node.size();
                }

                output += size[nextNode] * sum;
                sum += size[nextNode];
                output += size[nextNode];
            }
        }
        return output;
    }

    public void dfs(List<Integer> node, List<Integer>[] newEdges, int curNode, int father) {
        node.add(curNode);
        for (Integer nextNode : newEdges[curNode]) {
            if (np[nextNode] && father != nextNode) {
                dfs(node, newEdges, nextNode, curNode);
            }
        }
    }
}