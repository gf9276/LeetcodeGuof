package com.guof.dijkstra.network_latency;

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 求得就是最短距离的最大值
        // 这题 有环路
        Queue<int[]> queue = new LinkedList<>(); // 队列

        // 开始节点为k，加入k到所有其他点的信息
        for (int[] time : times) {
            if (time[0] == k) {
                queue.add(Arrays.copyOf(time, time.length));
            }
        }

        // 记录k到每个点的最小距离
        int[] all_point_time = new int[n];
        Arrays.fill(all_point_time, Integer.MAX_VALUE);
        all_point_time[k - 1] = 0;


        while (!queue.isEmpty()) {
            // 获取一个距离
            int[] curTime = queue.poll();

            // 更新最小距离
            int beforeCost = all_point_time[curTime[0] - 1]; // 前置路径长度
            int curCost = beforeCost + curTime[2];
            if (curCost < all_point_time[curTime[1] - 1]) {
                all_point_time[curTime[1] - 1] = curCost;
                for (int[] time : times) {
                    if (time[0] == curTime[1]) {
                        // 以终点作为新的起点，启动 ！
                        queue.add(Arrays.copyOf(time, time.length));
                    }
                }
            }
        }
        return Arrays.stream(all_point_time).max().getAsInt() != Integer.MAX_VALUE ? Arrays.stream(all_point_time).max().getAsInt() : -1;
    }
}