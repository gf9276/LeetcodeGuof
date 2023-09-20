package com.guof.picture_bfs.all_possible_paths;

import java.util.*;

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>(); // queue直接保存路径就好了
        queue.add(new ArrayList<>(List.of(0))); // 确实

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                List<Integer> curPath = queue.poll();
                assert curPath != null;
                int curIdx = curPath.get(curPath.size() - 1);
                for (int j = 0; j < graph[curIdx].length; j++) {
                    List<Integer> tmp = new ArrayList<>(curPath);
                    tmp.add(graph[curIdx][j]);
                    if (graph[curIdx][j] == graph.length - 1) {
                        output.add(tmp);
                    } else {
                        queue.add(tmp);
                    }
                }

            }
        }
        return output;
    }
}