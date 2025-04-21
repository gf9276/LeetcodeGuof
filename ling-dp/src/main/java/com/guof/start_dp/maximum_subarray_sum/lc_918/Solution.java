package com.guof.start_dp.maximum_subarray_sum.lc_918;


// leetcode 918
// 正难则反

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minAns = Integer.MAX_VALUE;
        int maxAns = Integer.MIN_VALUE;

        int maxCurNbr = 0;
        int minCurNbr = 0;
        int sum = 0;

        for (int num : nums) {
            minCurNbr = Math.min(minCurNbr + num, num);
            maxCurNbr = Math.max(maxCurNbr + num, num);
            minAns = Math.min(minAns, minCurNbr);
            maxAns = Math.max(maxAns, maxCurNbr);
            sum += num;
        }

        if (sum == minAns) {
            return maxAns;
        }

        return Math.max(maxAns, sum - minAns);
    }
}