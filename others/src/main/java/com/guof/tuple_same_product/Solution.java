package com.guof.tuple_same_product;


import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // 乘积，个数
        Arrays.sort(nums); // 不排序不好搞
        if (nums.length <= 3) {
            return 0;
        }
        // 出现一个后，其实是8个
        int curNbr = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i - 3; j++) {
                // 寻找潜在可能
                int curProduct = nums[i] * nums[j];
                curNbr += 8 * map.getOrDefault(curProduct, 0);
            }
            for (int j = 0; j < i; j++) {
                // 更新map
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        return curNbr;
    }
}