package com.feng.linear_dp.single_string_problem_ik.odd_even_jump;

import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int oddEvenJumps(int[] arr) {
        // 最后一个位置，默认成功的
        boolean[][] dp = new boolean[arr.length][2];
        dp[arr.length - 1][0] = true;
        dp[arr.length - 1][1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[arr.length - 1], arr.length - 1);
        int output = 1;

        for (int i = dp.length - 2; i >= 0; i--) {
            if (treeMap.containsKey(arr[i])) {
                dp[i][0] = dp[treeMap.get(arr[i])][1];
                dp[i][1] = dp[treeMap.get(arr[i])][0];
            } else {
                Integer oddMax = treeMap.higherKey(arr[i]);
                Integer evenMin = treeMap.lowerKey(arr[i]);

                dp[i][0] = oddMax != null && dp[treeMap.get(oddMax)][1];
                dp[i][1] = evenMin != null && dp[treeMap.get(evenMin)][0];
            }
            if (dp[i][0]){
                output++;
            }
            treeMap.put(arr[i], i);
        }

        return output;
    }
}