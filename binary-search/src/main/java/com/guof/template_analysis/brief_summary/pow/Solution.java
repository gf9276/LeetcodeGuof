package com.guof.template_analysis.brief_summary.pow;


class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;


        double curX = 1;

        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                curX *= x;
            }
            x *= x;
        }

        if (n < 0) return 1 / curX;
        return curX;
    }
}