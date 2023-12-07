package com.guof.min_reorder;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // bfs
        int output = 0;

        List<Integer>[] in = new List[n];
        List<Integer>[] out = new List[n];

        for (int i = 0; i < in.length; i++) {
            in[i] = new ArrayList<>();
        }
        for (int i = 0; i < out.length; i++) {
            out[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            out[connection[0]].add(connection[1]);
            in[connection[1]].add(connection[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> lastQueue = new LinkedList<>();
        queue.add(0);
        lastQueue.add(-1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPoint = queue.poll();
                int lastPoint = lastQueue.poll();
                for (int nextPoint : out[curPoint]) {
                    if (nextPoint == lastPoint) {
                        // 不允许重复
                        continue;
                    }
                    output += 1;
                    queue.add(nextPoint);
                    lastQueue.add(curPoint);
                }
                for (int nextPoint : in[curPoint]) {
                    if (nextPoint == lastPoint) {
                        // 不允许重复
                        continue;
                    }
                    queue.add(nextPoint);
                    lastQueue.add(curPoint);
                }
            }
        }
        return output;
    }
}