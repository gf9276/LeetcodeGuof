package com.guof.count_the_num_of_kfree_subsets;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int output;

    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums); // 从小到大排列，后面加进去的肯定比前面的大
        // 想用回溯
        output = 0; // 空集算上
        dfs(nums, k, -1, new HashSet<>());
        return output;
    }

    public void dfs(int[] nums, int k, int curIdx, Set<Integer> curSet) {
        // 进来了，就是一种可能性
        output++;

        int curNbr = curIdx >= 0 ? nums[curIdx] : Integer.MIN_VALUE;
        for (int i = curIdx + 1; i < nums.length; i++) {
            if (nums[i] == curNbr + k) {
                // 绝不安全
                continue;
            } else if (nums[i] < curNbr + k) {
                // 可能安全
                if (curSet.contains(nums[i] - k)) {
                    // 不能被加入
                    continue;
                }
            }

            curSet.add(nums[i]);
            dfs(nums, k, i, curSet);
            curSet.remove(nums[i]);
        }
    }
}