package com.guof.november122023_371.maximum_strong_pair_xor;


import java.util.Arrays;

class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums); // 算了，升序排序
        // 是这样的，要求两倍之内，异或的性质，能找到两倍的，肯定是最大的
        // 找不到两倍的，就找尽可能大的，肯定是答案，所以答案肯定是最大值^最大值/2，如果有的话，呵呵
        int output = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = nums.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] <= 2 * nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            for (int j = i + 1; j < left; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                output = Math.max(output, nums[j] ^ nums[i]);
            }
        }
        return output;
    }
}