package com.feng.template1.the_square_root_of_x;

class Solution {
    public int mySqrt(int x) {
        double left = 1;
        double right = x;

        while (right - left > 0.01) {

            double mid = (left + right) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return ((int) right * (int) right > x ? (int) left : (int) right);
    }
}