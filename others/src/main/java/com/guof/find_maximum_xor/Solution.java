package com.guof.find_maximum_xor;


import java.util.*;

class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            // 自己并自己，笑死
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int maxBit = 31 - Integer.numberOfLeadingZeros(max); // 获取第一个1的位置

        int mask = 0;
        int output = 0;
        for (int i = maxBit; i >= 0; i--) {
            mask = mask | (1 << i); // 更新掩码

            HashSet<Integer> set = new HashSet<>();

            // 只关注前面几位，后面的不关注了
            for (int num : nums) {
                set.add(num & mask);
            }

            int tmp = output | (1 << i); // 假设当前位置是1
            for (Integer item : set) {
                if (set.contains(item ^ tmp)) {
                    output = tmp;
                    break;
                }
            }
        }
        return output;
    }
}