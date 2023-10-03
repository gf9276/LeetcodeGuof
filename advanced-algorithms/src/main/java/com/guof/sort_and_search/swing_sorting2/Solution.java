package com.guof.sort_and_search.swing_sorting2;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] output = new int[nums.length];

        int p1 = (nums.length + 1) / 2 - 1;
        int p2 = nums.length - 1;
        int p = 0;

        while (p1 >= 0 && p2 >= (nums.length + 1) / 2) {
            output[p++] = nums[p1--];
            output[p++] = nums[p2--];
        }

        if ((nums.length) % 2 == 1) {
            output[p] = nums[p1];
        }

        System.arraycopy(output, 0, nums, 0, nums.length);
    }
}