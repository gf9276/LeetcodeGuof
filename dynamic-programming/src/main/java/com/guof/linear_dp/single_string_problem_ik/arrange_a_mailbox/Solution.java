package com.guof.linear_dp.single_string_problem_ik.arrange_a_mailbox;

import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public boolean canCross(int[] stones) {
        treeMap.clear();
        for (int i = 0; i < stones.length; i++) {
            treeMap.put(stones[i], i);
        }
        if (stones[1] != 1) {
            return false;
        }

        ArrayList<Integer>[] dp = new ArrayList[stones.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[1].add(1); // 第一块可以通过跳1步而来


        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].size(); j++) {
                for (int k = -1; k <= 1; k++) {
                    // 获取跳跃步数
                    int jumpDist = dp[i].get(j) + k;

                    // 跳跃步数不能为0
                    if (jumpDist <= 0) {
                        continue;
                    }

                    // 能跳到
                    if (treeMap.containsKey(stones[i] + jumpDist)) {
                        int nextIdx = treeMap.get(stones[i] + jumpDist);
                        if (!dp[nextIdx].contains(jumpDist)) {
                            dp[nextIdx].add(jumpDist);
                        }
                    }
                }
            }
        }

        return !dp[dp.length - 1].isEmpty();
    }
}