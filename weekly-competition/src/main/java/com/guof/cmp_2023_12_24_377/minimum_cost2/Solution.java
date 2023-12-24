package com.guof.cmp_2023_12_24_377.minimum_cost2;

import java.util.*;

class Solution {
    long output = Long.MAX_VALUE; // 计算成本
    Map<String, Integer> map = new HashMap<>();
    String[] original;
    String[] changed;
    int[] cost;
    long[][] g;

    public long minimumCost(String source, String target, String[] _original, String[] _changed, int[] _cost) {
        original = _original;
        changed = _changed;
        cost = _cost;
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(original));
        set.addAll(Arrays.asList(changed));
        int m = set.size();
        g = new long[m][m];
        List<String> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = i == j ? 0 : Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < original.length; i++) {
            g[map.get(original[i])][map.get(changed[i])] =
                    Math.min(cost[i], g[map.get(original[i])][map.get(changed[i])]);
        }
        floyd(g);
        dfs(source, target, 0);
        return output == Long.MAX_VALUE ? -1 : output;
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

    void dfs(String curSource, String curTarget, long curOutput) {
        if (curOutput >= output) {
            // 没意义了
            return;
        }
        // dfs的结局是什么呢
        if (curSource.isEmpty()) {
            output = curOutput;
            return;
        }

        if (curSource.charAt(0) == curTarget.charAt(0)) {
            // 开头相同，可以不匹配
            dfs(curSource.substring(1), curTarget.substring(1), curOutput);
        }
        for (String string : original) {
            if (string.length() > curSource.length()) {
                continue;
            }
            if (curSource.startsWith(string)) {
                for (String s : changed) {
                    // 这个部分匹配成功了
                    if (g[map.get(string)][map.get(s)] != Long.MAX_VALUE && curTarget.startsWith(s)) {
                        dfs(curSource.substring(string.length()),
                                curTarget.substring(s.length()),
                                curOutput + g[map.get(string)][map.get(s)]);
                    }
                }
            }
        }
    }
}