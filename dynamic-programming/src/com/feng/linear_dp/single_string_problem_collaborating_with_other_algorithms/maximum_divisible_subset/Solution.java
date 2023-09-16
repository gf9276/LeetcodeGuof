package com.feng.linear_dp.single_string_problem_collaborating_with_other_algorithms.maximum_divisible_subset;

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        List<List<Integer>> output = new ArrayList<>();
        for (int k : arr) {
            output.add(new ArrayList<>());
            output.get(output.size() - 1).add(k);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                int lastToLast = arr[j];
                int penultimate = arr[i];
                if (lastToLast % penultimate == 0) {
                    if (dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                        output.set(j, new ArrayList<>(output.get(i)));
                        output.get(j).add(arr[j]);
                    }
                }
            }
        }

        List<Integer> maxOutput = null;
        int tmp = 0;
        for (List<Integer> i : output) {
            if (i.size() > tmp) {
                tmp = i.size();
                maxOutput = i;
            }
        }

        return maxOutput;
    }
}