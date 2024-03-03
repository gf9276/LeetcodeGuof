package com.guof.cmp_2024_03_02_125.count_pairs_of_connectable_servers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//class Solution {
//    int n;
//    int[][] g;
//    List<Integer>[] lists;
//
//    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
//        // 计算点到点之间的距离
//        n = edges.length + 1;
//
//        lists = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            lists[i] = new ArrayList<>();
//        }
//        for (int[] edge : edges) {
//            lists[edge[0]].add(edge[1]);
//            lists[edge[1]].add(edge[0]);
//        }
//
//        g = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                g[i][j] = 0x3f3f3f3f;
//            }
//        }
//
//        for (int[] edge : edges) {
//            g[edge[0]][edge[1]] = edge[2];
//            g[edge[1]][edge[0]] = edge[2];
//        }
//        floyd(g);
//
//        // g包含了点到点之间的距离
//
//        int[] output = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            // 枚举每一个中转点
//
//        }
//
//        return output;
//
//    }
//
//    void floyd(int[][] g) {
//        int n = g.length;
//        // floyd 基本流程为三层循环: [枚举中转点 - 枚举起点 - 枚举终点] => 松弛操作
//        for (int p = 0; p < n; p++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    g[i][j] = Math.min(g[i][j], g[i][p] + g[p][j]);
//                }
//            }
//        }
//    }
//}

class Solution {
    int n;
    int[][] g;
    List<Integer>[] lists;
    int[] output;
    int signalSpeed;
    Map<Integer, List<Integer>>[] maps;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        // 计算点到点之间的距离
        this.signalSpeed = signalSpeed;
        n = edges.length + 1;
        g = new int[n][n];
        for (int[] edge : edges) {
            g[edge[0]][edge[1]] = edge[2];
            g[edge[1]][edge[0]] = edge[2];
        }

        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }

        maps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
        }

        dfs(0, -1);

        output = new int[n];

        dfs2(0, -1);

        return output;

    }

    public void cnt(int curIdx) {
        List<Integer> nums = new ArrayList<>();
        if (maps[curIdx].size() > 1) {
            for (int key : maps[curIdx].keySet()) {
                int curNbr = 0;
                for (int curDist : maps[curIdx].get(key)) {
                    if (curDist % signalSpeed == 0) {
                        curNbr++;
                    }
                }
                nums.add(curNbr);
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int num : nums) {
            sum -= num;
            output[curIdx] += sum * num;
        }
    }

    public void dfs(int curIdx, int father) {
        for (int nextIdx : lists[curIdx]) {
            if (nextIdx == father) {
                continue;
            }
            if (!maps[curIdx].containsKey(nextIdx)) {
                maps[curIdx].put(nextIdx, new ArrayList<>());
            }
            maps[curIdx].get(nextIdx).add(g[curIdx][nextIdx]);

            dfs(nextIdx, curIdx);

            for (List<Integer> nextIdxValue : maps[nextIdx].values()) {
                for (int tmp : nextIdxValue) {
                    maps[curIdx].get(nextIdx).add(tmp + g[curIdx][nextIdx]);
                }
            }

        }
    }

    public void dfs2(int curIdx, int father) {
        cnt(curIdx);
        for (int nextIdx : lists[curIdx]) {
            if (nextIdx == father) {
                continue;
            }

            // 切换next和cur的位置
            maps[nextIdx].put(curIdx, new ArrayList<>());
            maps[nextIdx].get(curIdx).add(g[nextIdx][curIdx]);
            for (int key : maps[curIdx].keySet()) {
                if (key == nextIdx) {
                    continue;
                }
                for (int dist : maps[curIdx].get(key)) {
                    maps[nextIdx].get(curIdx).add(dist + g[curIdx][nextIdx]);
                }
            }

            // 继续向下遍历
            dfs2(nextIdx, curIdx);
        }
    }
}