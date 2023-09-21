package com.guof.prime.min_cost_of_connecting_all_points;

import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        if (points.length == 2) {
            return Math.abs(points[0][1] - points[1][1]) + Math.abs(points[0][0] - points[1][0]);
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost)); // 升序排列的队列

        int[][] distMat = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distMat[i][j] = Math.abs(points[i][1] - points[j][1]) + Math.abs(points[i][0] - points[j][0]);
                distMat[j][i] = distMat[i][j];
            }
        }

        // 获取边的关系
        for (int i = 0; i < points.length; i++) {
            queue.add(new Edge(0, i, distMat[0][i])); // 添加进去
        }

        // prime 维护两个集合 遍历过的 没遍历过的
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(0);
        for (int i = 1; i < points.length; i++) {
            set2.add(i);
        }

        int output = 0;
        while (!set2.isEmpty()) {
            Edge curEdge = queue.poll();
            assert curEdge != null;
            if (set1.contains(curEdge.point1) && set1.contains(curEdge.point2)) {
                continue;
            }

            int minDist = curEdge.cost;
            int visitPoint = curEdge.point2;

            set1.add(visitPoint);
            set2.remove(visitPoint);
            output += minDist;

            for (int unVisitedPoint : set2) {
                queue.add(new Edge(visitPoint, unVisitedPoint, distMat[visitPoint][unVisitedPoint]));
            }
        }
        return output;
    }

    static class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }
}