package com.guof.nth_magical_number;


class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        // 有点像是二分法啊
        int mod = 1000000007;
        int minAB = Math.min(a, b); // 小的那个
        int maxAB = Math.max(a, b); // 大的那个

        int ab = maxAB;
        while (ab % minAB != 0) {
            ab += maxAB;
        }

        long right = (long) minAB * n + 1; // 启动
        long left = 0; // 还是用左闭右开吧

        while (left < right) {
            long mid = (right - left) / 2 + left;
            if (mid / minAB + mid / maxAB - mid / ab < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left % mod);
    }
}