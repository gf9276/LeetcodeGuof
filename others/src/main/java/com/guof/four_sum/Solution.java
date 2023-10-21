package com.guof.four_sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 想用dfs
        Arrays.sort(nums);
        dfs(0, nums, target, new ArrayList<>());
        return output;
    }

    public void dfs(int curNbr, int[] nums, int target, List<Integer> list) {
        if (list.size() == 4) {
            // 到长度了，要么留下，要么滚
            long sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += list.get(i);
            }
            if (sum == target) {
                output.add(new ArrayList<>(list));
            }
            return;
        }

        Integer lastNbr = null;
        for (int i = curNbr; i < nums.length; i++) {
            if (lastNbr != null && nums[i] == lastNbr) {
                continue;
            }
            long sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum + (long) nums[i] * (4 - list.size()) > target) {
                break;
            }
            lastNbr = nums[i];
            list.add(nums[i]);
            dfs(i + 1, nums, target, list);
            list.remove(list.size() - 1);
        }
    }
}