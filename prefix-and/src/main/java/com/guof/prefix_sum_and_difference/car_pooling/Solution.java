package com.guof.prefix_sum_and_difference.car_pooling;

class Solution {
    public boolean carPooling(int[][] bookings, int n) {
        int[] output = new int[1001]; // 终点不超过1000 0~1000

        // 记录变化
        for (int[] booking : bookings) {
            output[booking[1]] += booking[0];
            output[booking[2]] -= booking[0];

        }

        for (int i = 0; i < output.length; i++) {
            output[i] += i - 1 >= 0 ? output[i - 1] : 0;
            if (output[i] > n) {
                return false;
            }
        }
        return true;
    }
}