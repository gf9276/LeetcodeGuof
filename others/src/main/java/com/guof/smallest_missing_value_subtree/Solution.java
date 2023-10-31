package com.guof.smallest_missing_value_subtree;


import java.util.*;

class Solution {
    boolean[] visit;
    int[] output;
    Map<Integer, List<Integer>> map;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        output = new int[parents.length];
        visit = new boolean[Arrays.stream(nums).max().getAsInt() + 1]; // 记得要减去1
        Arrays.fill(output, 1);
        Arrays.fill(visit, false); // 一开始全都灭有
        map = new HashMap<>();
        int curIdx = -1;

        // 记录所有的父节点情况
        for (int i = 0; i < parents.length; i++) {
            // 把子节点放到map里，相对好一点，从小到大，有序排列的
            if (nums[i] == 1) {
                curIdx = i;
            }
            List<Integer> tmp = map.getOrDefault(parents[i], new ArrayList<>());
            tmp.add(i);
            map.put(parents[i], tmp);
        }

        if (curIdx == -1) {
            // 没有1，那么全玩完
            return output;
        }

        // curIdx现在是1的那个点
        int minLimited = 2;
        while (curIdx != -1) {
            dfs(nums, curIdx); // 开始获取该节点子树的情况
            visit[nums[curIdx] - 1] = true; // 把该节点也加上
            for (int i = minLimited - 1; i < visit.length; i++) {
                if (!visit[i]) {
                    output[curIdx] = i + 1;
                    minLimited = output[curIdx];
                    break;
                }
            }
            curIdx = parents[curIdx];
        }

        return output;
    }


    /**
     * 寻找当前节点下的可视内容
     *
     * @param nums
     * @param curIdx
     */
    public void dfs(int[] nums, int curIdx) {
        if (!map.containsKey(curIdx)) {
            // 该点不能成为父节点
            return;
        }
        for (int i = 0; i < map.get(curIdx).size(); i++) {
            if (!visit[nums[map.get(curIdx).get(i)] - 1]) {
                // 如果该点没有访问过，访问一下
                dfs(nums, map.get(curIdx).get(i));
            }
            visit[nums[map.get(curIdx).get(i)] - 1] = true;
        }
    }
}