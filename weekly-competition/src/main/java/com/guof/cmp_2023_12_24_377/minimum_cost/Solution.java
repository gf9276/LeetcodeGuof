package com.guof.cmp_2023_12_24_377.minimum_cost;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // 个人人为是图
        long[][] g = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                g[i][j] = i == j ? 0 : Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < original.length; i++) {
            g[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], g[original[i] - 'a'][changed[i] - 'a']);
        }
        floyd(g);
        long output = 0;
        for (int i = 0; i < source.length(); i++) {
            if (g[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Long.MAX_VALUE) {
                return -1;
            } else {
                output += g[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }
        return output;
    }

    void floyd(long[][] g) {
        int n = g.length;
        // floyd 基本流程为三层循环: [枚举中转点 - 枚举起点 - 枚举终点] => 松弛操作
        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!(g[i][p] == Long.MAX_VALUE || g[p][j] == Long.MAX_VALUE)) {
                        g[i][j] = Math.min(g[i][j], g[i][p] + g[p][j]);
                    }
                }
            }
        }
    }
}