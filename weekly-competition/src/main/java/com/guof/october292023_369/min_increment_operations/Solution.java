package com.guof.october292023_369.min_increment_operations;


import java.util.Arrays;

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        // 意思就是，三步之内，最大值必须大于等于k
        // 那不就三种情况，每隔三个变一下 起始位置 012
        // 还得不停调整位置
        int i = nums.length;
        long[] arr = new long[]{dfs(i - 1, nums, k), dfs(i - 2, nums, k), dfs(i - 3, nums, k)};
        Arrays.sort(arr);
        return arr[0];
    }

    public long dfs(int i, int[] nums, int k) {
        if (i < 0) {
            return 0;
        }

        long[] arr = new long[]{dfs(i - 1, nums, k), dfs(i - 2, nums, k), dfs(i - 3, nums, k)};
        Arrays.sort(arr);

        return arr[0] + Math.max(0, k - nums[i]);
    }
}