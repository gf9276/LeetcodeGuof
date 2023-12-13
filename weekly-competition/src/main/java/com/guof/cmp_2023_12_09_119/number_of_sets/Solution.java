package com.guof.cmp_2023_12_09_119.number_of_sets;

//class Solution {
//    public int numberOfSets(int n, int maxDistance, int[][] roads) {
//        int inf = 0x3f3f3f3f;
//        int[][] w = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                w[i][j] = inf;
//                if (i == j) {
//                    w[i][j] = 0;
//                }
//            }
//        }
//        for (int[] road : roads) {
//            w[road[0]][road[1]] = Math.min(w[road[0]][road[1]], road[2]);
//            w[road[1]][road[0]] = w[road[0]][road[1]];
//        }
//
//
//    }
//
//    void floyd(Set<Integer> keepSet) {
//        // floyd 基本流程为三层循环：
//        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
//        for (int p : keepSet.toArray(new Integer[0])) {
//            for (int i : keepSet.toArray(new Integer[0])) {
//                for (int j : keepSet.toArray(new Integer[0])) {
//                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
//                }
//            }
//        }
//    }
//}