package com.guof.more_practice3.divide;

class Solution {
    public int divide(int dividend, int divisor) {
        // 位移，移的是补码！
        // 处理一下边界情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }

        // 先保留符号
        if (dividend == 0) {
            return 0;
        }
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        dividend *= dividend > 0 ? -1 : 1;
        divisor *= divisor > 0 ? -1 : 1;

        int output = 0;
        while (dividend <= divisor) {
            int x = -divisor;
            int cnt = 1;
            while ((x << 1) > 0 && -(x << 1) > dividend) {
                x <<= 1;
                cnt <<= 1;
            }
            dividend += x;
            output += cnt;
        }
        return output * sign;
    }
}