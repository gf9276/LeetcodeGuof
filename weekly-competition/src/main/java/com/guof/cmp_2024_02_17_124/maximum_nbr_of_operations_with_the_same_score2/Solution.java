package com.guof.cmp_2024_02_17_124.maximum_nbr_of_operations_with_the_same_score2;

import java.util.HashMap;

class Solution {
    int[] nums;

    HashMap<Integer, Integer[][]> dpMap;

    public int maxOperations(int[] _nums) {
        dpMap = new HashMap<>();
        if (_nums.length < 2) {
            return 0;
        }
        if (_nums.length < 4) {
            return 1;
        }
        // 记忆化搜索，先试试DFS
        nums = _nums;

        return dfs(0, nums.length - 1, -1);
    }

    public int dfs(int begin, int end, int score) {
        // 在[begin, end] 的情况下，能执行的次数
        if (end - begin < 1) {
            // 没有位置了
            return 0;
        }

        if (dpMap.containsKey(score) && dpMap.get(score)[begin][end] != null) {
            return dpMap.get(score)[begin][end];
        }

        int ans = 0;
        if ((nums[begin] + nums[begin + 1]) == score || score == -1) {
            int curScore = nums[begin] + nums[begin + 1];
            if (!dpMap.containsKey(curScore)) {
                dpMap.put(curScore, new Integer[nums.length + 10][nums.length + 10]);
            }
            int tmp = dfs(begin + 2, end, curScore) + 1;
            dpMap.get(curScore)[begin][end] = tmp;
            ans = Math.max(ans, tmp);
        }
        if ((nums[begin] + nums[end]) == score || score == -1) {
            int curScore = nums[begin] + nums[end];
            if (!dpMap.containsKey(curScore)) {
                dpMap.put(curScore, new Integer[nums.length + 10][nums.length + 10]);
            }
            int tmp = dfs(begin + 1, end - 1, curScore) + 1;
            dpMap.get(curScore)[begin][end] = tmp;
            ans = Math.max(ans, tmp);
        }
        if ((nums[end - 1] + nums[end]) == score || score == -1) {
            int curScore = nums[end - 1] + nums[end];
            if (!dpMap.containsKey(curScore)) {
                dpMap.put(curScore, new Integer[nums.length + 10][nums.length + 10]);
            }
            int tmp = dfs(begin, end - 2, (nums[end - 1] + nums[end])) + 1;
            dpMap.get(curScore)[begin][end] = tmp;
            ans = Math.max(ans, tmp);
        }

        return ans;
    }
}