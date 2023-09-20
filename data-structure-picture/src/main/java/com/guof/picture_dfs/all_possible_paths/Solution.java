package com.guof.picture_dfs.all_possible_paths;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> output;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 不就是回溯嘛，切
        output = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>());
        return output;
    }

    public void dfs(int[][] graph, int curIdx, List<Integer> path) {
        if (curIdx == graph.length - 1) {
            List<Integer> onePath = new ArrayList<>(path);
            onePath.add(curIdx);
            output.add(onePath);
            // 已经抵达中点了
            return;
        }
        path.add(curIdx);
        for (int i = 0; i < graph[curIdx].length; i++) {
            dfs(graph, graph[curIdx][i], path);
        }
        path.remove(path.size() - 1);
    }
}