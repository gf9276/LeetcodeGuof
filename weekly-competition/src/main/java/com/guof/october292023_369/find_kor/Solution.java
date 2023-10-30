package com.guof.october292023_369.find_kor;


class Solution {
    public int findKOr(int[] nums, int k) {
        // 至少存在k个元素第i位是1
        int[] arr = new int[32]; // 0~31位

        for (int num : nums) {
            for (int i = 0; i < arr.length; i++) {
                if (((1 << i) & num) == (1 << i)) {
                    arr[i]++;
                }
            }
        }

        int output = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= k) {
                output += (1 << i);
            }
        }
        return output;
    }
}