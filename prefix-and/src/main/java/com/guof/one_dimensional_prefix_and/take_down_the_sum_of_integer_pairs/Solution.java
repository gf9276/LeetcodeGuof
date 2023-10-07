package com.guof.one_dimensional_prefix_and.take_down_the_sum_of_integer_pairs;


class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        int numsMax = 0;
        for (int num : nums) {
            numsMax = Math.max(numsMax, num);
        }
        int[] prefix = new int[numsMax + 1];

        // num是正整数，统计每个数字出现的个数
        for (int num : nums) {
            prefix[num]++;
        }
        // 计算前缀和
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        long output = 0;
        for (int i = 1; i < prefix.length; i++) {
            int sameNbr = prefix[i] - prefix[i - 1]; // 获取当前数字的个数
            // 这里才是精华，直接跳跃一个大区间了，妙啊
            for (int j = i; j <= numsMax; j += i) {
                int curNbr = prefix[Math.min(numsMax, j + i - 1)] - prefix[j - 1];
                output += (long) curNbr * sameNbr * (j / i);
                output %= 1000000007;
            }
        }
        return (int) output;
    }
}