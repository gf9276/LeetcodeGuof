package com.guof.backtracking_algorithm.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.backtracking_algorithm.permutations
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 14:48
 * @Version 1.0
 */
//class Solution {
//
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        backtrack(output, new ArrayList<>(), nums);
//        return output;
//    }
//
//    public void backtrack(List<List<Integer>> output, List<Integer> tempList, int[] nums) {
//        List<Integer> newTmpList = new ArrayList<>(tempList); // 必须新建一个
//
//        if (tempList.size() == nums.length) {
//            // 如果长度对了，直接退出
//            output.add(newTmpList);
//            return;
//        }
//
//        for (int num : nums) {
//            if (newTmpList.contains(num)) {
//                // 存在重复直接跳过
//                continue;
//            }
//            newTmpList.add(num);
//            backtrack(output, newTmpList, nums);
//            newTmpList.remove(newTmpList.size() - 1);
//        }
//    }
//}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(nums, output, new ArrayList<>());
        return output;
    }

    public void dfs(int[] nums, List<List<Integer>> output, List<Integer> tmpList) {
        if (tmpList.size() == nums.length) {
            output.add(new ArrayList<>(tmpList));
            return;
        }

        for (int num : nums) {
            if (tmpList.contains(num)) {
                continue;
            }
            tmpList.add(num);
            dfs(nums, output, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}