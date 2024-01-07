package com.guof.cmp_2024_01_07_379.min_moves_to_capture_the_queen;

import java.util.Arrays;

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // 感觉最多3步啊

        if (a == e) {
            // 同一行
            if (c == a && (d - b) * (d - f) < 0) {
                // 堵在路上了
                return 2;
            } else {
                // 没堵住
                return 1;
            }
        }


        if (b == f) {
            // 同一列
            if (b == d && (c - a) * (c - e) < 0) {
                // 堵在路上了
                return 2;
            } else {
                // 没堵住
                return 1;
            }
        }

        if (Math.abs(f - d) == Math.abs(e - c)) {
            // 一条斜线，斜率可以是正负1
            int k = (f - d) / (e - c); // +-1嘛
            int tmpB = f - k * e;
            if ((b - d) * (b - f) < 0 && k * a + tmpB == b) {
                // 堵在路上了
                return 2;
            } else {
                // 秒杀
                return 1;
            }
        }

        int[] output = new int[2];
        // 不在同一行 同一列
        // 移动到同一行

        Arrays.fill(output, 4); // 最多3步

        // 变a到同一行
        if (!(e == c && b == d)) {
            // 没有冲突才能变
            output[0] = minMovesToCaptureTheQueen(e, b, c, d, e, f) + 1;
        }

        // 变b到同一列
        if (!(a == c && f == d)) {
            // 没有冲突才能变
            output[1] = minMovesToCaptureTheQueen(a, f, c, d, e, f) + 1;
        }

        Arrays.sort(output);
        return output[0];
    }
}