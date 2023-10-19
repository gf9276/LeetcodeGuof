package com.guof.eliminating_games;


class Solution {
    public int lastRemaining(int n) {
        int curBegin = 1;
        int step = 1;

        while (n >= 1) {
            if (n == 1) {
                return curBegin;
            }

            // 正向传播
            n = n - (n + 1) / 2;
            curBegin += step;
            step *= 2;

            if (n == 1) {
                return curBegin;
            }

            // 反向传播
            if (n % 2 != 0) {
                // 如果是奇数个, curBegin往前挪动
                curBegin += step;
            }
            n = n - (n + 1) / 2;
            step *= 2;

            if (n == 1) {
                return curBegin;
            }
        }
        return 0;
    }
}