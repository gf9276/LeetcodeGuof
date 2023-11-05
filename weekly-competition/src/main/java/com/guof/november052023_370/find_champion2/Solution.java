package com.guof.november052023_370.find_champion2;


class Solution {
    public int findChampion(int n, int[][] edges) {
        // 统计每个队伍的入度？感觉统计入度就好了
        int[] in = new int[n];

        for (int[] edge : edges) {
            in[edge[1]]++;
        }

        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                if (champion == -1) {
                    champion = i;
                } else {
                    champion = -1;
                    break;
                }
            }
        }
        return champion;
    }
}