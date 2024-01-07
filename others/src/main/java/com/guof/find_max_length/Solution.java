package com.guof.find_max_length;


import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        int output = 0;
        // 以i为结尾的最长相等长度是？

        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] == 0 ? -1 : nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // 0第一次出现在0这个位置
        for (int i = 1; i < sum.length; i++) {
            if (map.containsKey(sum[i])) {
                output = Math.max(output, i - map.get(sum[i]));
            } else {
                map.put(sum[i], i);
            }
        }

        return output;
    }
}