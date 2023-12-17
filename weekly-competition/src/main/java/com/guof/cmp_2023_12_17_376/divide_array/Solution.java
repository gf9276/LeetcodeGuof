package com.guof.cmp_2023_12_17_376.divide_array;

import java.util.*;

class Solution {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        // 不是平均数，应该是中位数
        List<Integer> mids = new ArrayList<>();
        mids.add(nums[nums.length / 2]);
        if (nums.length % 2 == 0) {
            mids.add(nums[nums.length / 2 - 1]);
        }
        // 寻找中位数最近的两个回文串，自然是左右回文串了，左右回文串的差别主要是在中间那个数字上
        Set<Integer> set = new HashSet<>();
        for (int mid : mids) {
            int curPalindrome = getPalindrome(mid);
            set.add(curPalindrome);
            if (curPalindrome == mid) {
                // 正好等于中位数，不是完美？
                continue;
            }

            String str = String.valueOf(mid);
            if (curPalindrome > mid) {
                // 获取左侧回文串
                mid -= (int) Math.pow(10, (double) (int) (str.length() / 2));
            } else {
                mid += (int) Math.pow(10, (double) (int) (str.length() / 2));
            }
            set.add(getPalindrome(mid));
        }


        long output = Long.MAX_VALUE;
        for (int curNbr : set) {
            long curSum = 0;
            for (int num : nums) {
                curSum += Math.abs(curNbr - num);
            }
            output = Math.min(output, curSum);
        }
        return output;
    }

    int getPalindrome(int mid) {
        char[] chars = String.valueOf(mid).toCharArray();
        for (int j = 0; j < chars.length / 2; j++) {
            // 变成回文串
            chars[chars.length - 1 - j] = chars[j];
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}