package com.feng.more_practice2.maximum_value_of_split_array;


class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            int curSum = 0;
            int boxCnt = 1;
            for (int num : nums) {
                if (curSum + num > mid) {
                    curSum = 0;
                    boxCnt++;
                }
                curSum += num;
            }

            if (boxCnt > k) {
                // 太多了，说明这个mid太小了
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;
    }
}