package com.guof.subsets;


import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> output;

    public List<List<Integer>> subsets(int[] nums) {
        // 这种遍历的，真的就是只是遍历啊
        output = new ArrayList<>();
        output.add(new ArrayList<>());

        dfs(new ArrayList<>(), 0, nums);

        return output;
    }

    public void dfs(List<Integer> tmpList, int curIdx, int[] nums) {
        if (curIdx >= nums.length) {
            return;
        }

        tmpList.add(nums[curIdx]);
        output.add(new ArrayList<>(tmpList));
        dfs(tmpList, curIdx + 1, nums);
        tmpList.remove(tmpList.size() - 1);

        dfs(tmpList, curIdx + 1, nums);
    }
}