package com.feng.template_analysis.effective_perfect_squares;


class Solution {
    public boolean isPerfectSquare(int num) {

        double start = 1;
        double end = num;

        while (Math.abs(end - start) > 0.001) {
            double mid = (start + end) / 2;
            if (mid * mid > num) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return (int) start * (int) start == num || (int) (start + 1) * (int) (start + 1) == num;

    }
}