package com.guof.prefix_sum_and_difference.min_moves;

import java.util.Arrays;

class Solution {
    public int minMoves(int[] nums, int limit) {

        // 和 变成 x 需要的步数
        int[] res = new int[2 * limit + 2];
        Arrays.fill(res, 0, 2, Integer.MAX_VALUE);
        res[2] = nums.length;

        for (int i = 0; i < nums.length / 2; i++) {
            int A = nums[i];
            int B = nums[nums.length - 1 - i];

            int left = Math.min(A, B) + 1;
            int right = Math.max(A, B) + limit;
            res[left] -= 1;
            res[right + 1] += 1;

            left = A + B;
            right = A + B;
            res[left] -= 1;
            res[right + 1] += 1;
        }

        int output = res[2];
        for (int i = 3; i < res.length - 1; i++) {
            res[i] += res[i - 1];
            output = Math.min(output, res[i]);
        }
        return output;
    }
}