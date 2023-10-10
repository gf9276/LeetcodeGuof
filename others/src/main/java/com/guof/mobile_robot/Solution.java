package com.guof.mobile_robot;


import java.util.Arrays;

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        long[] arr = new long[nums.length];

        for (int j = 0; j < nums.length; j++) {
            arr[j] = (long) nums[j] + (s.charAt(j) == 'R' ? d : -d);
        }

        Arrays.sort(arr);

        // 排完序了统计数量
        long output = 0;
        long sum = 0;
        for (int j = 0; j < arr.length; j++) {
            output = (output + j * arr[j] - sum) % 1000000007;
            sum += arr[j];
        }
        return (int) output;
    }
}