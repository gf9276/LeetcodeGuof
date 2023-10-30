package com.guof.october292023_369.min_sum;


class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        // 计算和
        long sum1 = 0;
        long sum2 = 0;

        // 计算0的个数，不要随便用流，会变得不幸
        long zero1 = 0;
        long zero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            zero1 += (num == 0) ? 1 : 0;
        }
        for (int num : nums2) {
            sum2 += num;
            zero2 += (num == 0) ? 1 : 0;
        }

        // 肯定以大的为标准
        long nums1SumMin = zero1 + sum1; // 0全变成1，就是最小值
        long nums2SumMin = zero2 + sum2;

        long nums1SumMax = zero1 != 0 ? Long.MAX_VALUE : sum1; // 0 可以变成任意一个正整数
        long nums2SumMax = zero2 != 0 ? Long.MAX_VALUE : sum2; // 所以只要有一个0，上限就是无穷大

        if (nums1SumMin >= nums2SumMin && nums1SumMin <= nums2SumMax) {
            return nums1SumMin;
        } else if (nums2SumMin >= nums1SumMin && nums2SumMin <= nums1SumMax) {
            return nums2SumMin;
        }
        return -1;
    }
}