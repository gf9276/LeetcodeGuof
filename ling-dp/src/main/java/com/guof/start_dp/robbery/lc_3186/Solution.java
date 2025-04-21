package com.guof.start_dp.robbery.lc_3186;


// leetcode 2320
// 打家劫舍

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Long> map = new HashMap<>();
        for (long i : power) {
            // 统计所有的存在
            map.put(i, map.getOrDefault(i, 0L) + 1);
        }


        long[] map2Int = new long[map.size()];
        int idx = 0;
        for (long key : map.keySet()) {
            map2Int[idx++] = key;
        }

        Arrays.sort(map2Int); // 排序 1 6 7


        long[] dp = new long[map.size() + 1];
        dp[0] = 0; // 一个都没用，就没有伤害
        dp[1] = map2Int[0] * map.get(map2Int[0]); // 用了一个哈
        if (map2Int.length == 1) {
            return dp[1];
        }
        if (map2Int[1] - 2 > map2Int[0]) {
            dp[2] = dp[1] + map2Int[1] * map.get(map2Int[1]);
        } else {
            dp[2] = Math.max(dp[1], map2Int[1] * map.get(map2Int[1]));
        }
        for (int i = 3; i < dp.length; i++) {
            long curNbr = map2Int[i - 1] * map.get(map2Int[i - 1]); // 这是当前的伤害
            dp[i] = dp[i - 3] + curNbr; // 不可能重复了
            if (map2Int[i - 1] - 2 > map2Int[i - 2]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + curNbr);
            } else {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            if (map2Int[i - 1] - 2 > map2Int[i - 3]) {
                dp[i] = Math.max(dp[i], dp[i - 2] + curNbr);
            } else {
                dp[i] = Math.max(dp[i], dp[i - 2]);
            }
        }
        return dp[dp.length - 1];
    }
}