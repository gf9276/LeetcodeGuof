package com.guof.practical_application_hash_mapping.max_number_of_consecutive1_3;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int maxSize = 0;
        int oneTime = 0;

        while (fast < nums.length) {
            if (nums[fast] == 1) {
                oneTime++;
            }
            if (fast - slow + 1 - oneTime > k) {
                while (nums[slow++] == 1) {
                    oneTime--;
                }
            } else {
                maxSize = Math.max(maxSize, fast + 1 - slow);
            }
            fast++;
        }
        return maxSize;
    }
}