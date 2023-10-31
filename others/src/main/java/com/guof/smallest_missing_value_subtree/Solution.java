package com.guof.smallest_missing_value_subtree;


import java.util.*;

class Solution {
    int[] output;
    Map<Integer, List<Integer>> map;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        output = new int[parents.length];
        map = new HashMap<>();

        // 记录所有的父节点情况
        for (int i = 0; i < parents.length; i++) {
            // 把子节点放到map里，相对好一点
            List<Integer> tmp = map.getOrDefault(parents[i], new ArrayList<>());
            tmp.add(i);
            map.put(parents[i], tmp);
        }

        dfs(nums, 0);
        return output;
    }

    public PriorityQueue<Integer> dfs(int[] nums, int curIdx) {
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        list.add(new PriorityQueue<>());
        // 寻找子节点
        if (map.containsKey(curIdx)) {
            for (int i = 0; i < map.get(curIdx).size(); i++) {
                // 找到了一个子节点
                list.add(dfs(nums, map.get(curIdx).get(i)));
            }
        }

        PriorityQueue<Integer> outputHeap = list.get(0);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                outputHeap.addAll(list.get(i));
            }
        }
        outputHeap.add(nums[curIdx]); // 加上当前值
        int i = 1;
        while(!outputHeap.isEmpty())

        output[curIdx] = outputHeap.peek();
        return outputHeap;
    }
}