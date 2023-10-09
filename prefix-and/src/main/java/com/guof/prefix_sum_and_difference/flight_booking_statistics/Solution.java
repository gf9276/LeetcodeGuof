package com.guof.prefix_sum_and_difference.flight_booking_statistics;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] output = new int[n];

        // 记录变化
        for (int[] booking : bookings) {
            output[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                output[booking[1]] -= booking[2];
            }
        }


        for (int i = 1; i < n; i++) {
            output[i] += output[i - 1];
        }

        return output;
    }
}