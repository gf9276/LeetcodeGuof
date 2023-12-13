package com.guof.cmp_2023_12_09_119.max_subarray_length;

import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // 这题目有点眼熟，双指针，应该要记录第一个数出现的idx
        // 考虑到nums[i]范围特别大，用map吧
        int output = 1; // 记录最大的长度
        Map<Integer, Deque<Integer>> map = new HashMap<>(); // 记录这个数字出现的位置
        map.put(nums[0], new LinkedList<>(List.of(0)));
        int left = 0;
        int right = 1;
        for (; right < nums.length; right++) {
            if (!map.containsKey(nums[right])) {
                map.put(nums[right], new LinkedList<>(List.of(right)));
            } else {
                // 存在了
                if (map.get(nums[right]).size() < k) {
                    map.get(nums[right]).add(right); // 还可以放入
                } else {
                    // 放不进去了，得扔掉一个
                    left = Math.max(left, map.get(nums[right]).pollFirst() + 1);
                    map.get(nums[right]).addLast(right); // 添加新元素的位置
                }
            }
            output = Math.max(right - left + 1, output);
        }
        return output;
    }
}