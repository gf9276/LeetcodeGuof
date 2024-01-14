package com.guof.cmp_2024_01_14_380.find_maximum_number;

class Solution {
    public long findMaximumNumber(long k, int x) {
        long left = 0;
        long right = (long) Math.pow(10, 18);

        while (left < right) {
            long mid = (right - left) / 2 + left;

            long sum = 0;
            for (int i = x; i < 50; i += x) {
                long add = (mid + 1) / (1L << i) * (1L << (i - 1));
                sum += add;
                long l = (mid + 1) / (1L << i) * (1L << (i));
                if (l < mid + 1) {
                    sum += Math.max(0, (mid + 1) - l - (1L << (i - 1)));
                }
                if (sum > k) {
                    break;
                }
            }

            if (sum <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}