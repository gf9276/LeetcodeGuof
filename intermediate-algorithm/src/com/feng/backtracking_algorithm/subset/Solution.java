package com.feng.backtracking_algorithm.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.backtracking_algorithm.subset
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 15:19
 * @Version 1.0
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), nums, 0);
        return output;
    }

    public void backtrack(List<List<Integer>> output, List<Integer> tempList, int[] nums, int start) {
        List<Integer> newTmpList = new ArrayList<>(tempList); // 必须新建一个
        output.add(newTmpList);
        for (int i = start; i < nums.length; i++) {
            newTmpList.add(nums[i]);
            backtrack(output, newTmpList, nums, i + 1);
            newTmpList.remove(newTmpList.size() - 1);
        }
    }
}