package com.guof.can_complete_circuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        int[] dp = new int[gas.length]; // 从i到j还剩余的油
        List<Integer> beginIdxs = new ArrayList<>();

        for (int i = 0; i < gas.length; i++) {
            int lastIdx = (i + gas.length - 1) % dp.length;
            int curIdx = (i + gas.length) % dp.length;
            if (gas[lastIdx] - cost[lastIdx] <= 0 && gas[curIdx] - cost[curIdx] > 0) {
                beginIdxs.add(curIdx);
            }
        }

        for (int i : beginIdxs) {
            Arrays.fill(dp, -1);
            dp[i] = gas[i];
            for (int j = 1; j < dp.length; j++) {
                int lastIdx = (i + j - 1) % dp.length;
                int curIdx = (i + j) % dp.length;

                if (dp[lastIdx] < cost[lastIdx]) {
                    dp[curIdx] = -1; // 无法抵达
                    break;
                } else {
                    dp[curIdx] = dp[lastIdx] - cost[lastIdx] + gas[curIdx]; // 减去消耗的油，并当场补充
                }
            }
            int lastIdx = (i + dp.length - 1) % dp.length;
            int curIdx = (i + dp.length) % dp.length;
            if (dp[lastIdx] >= cost[lastIdx]) {
                return curIdx;
            }
        }

        return -1;
    }
}