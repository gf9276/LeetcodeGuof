package com.guof.cmp_2024_01_21_381.count_of_pairs;

import java.util.Arrays;

class Solution {
    int x;
    int y;
    int n;

    // 对于所有的点来说，从a到b，
    // a<=x之前，b在x之前，不影响
    // a在x之前，b在xy之间，影响，影响一半
    // a在x之前，b在y之后，影响，直接跳跃xy
    // a在xy之间，b在xy之间，影响，循环起来
    // a在xy之间，b在y之后，影响，影响一半
    // a在y之后，b在y之后，不影响

    public long[] countOfPairs(int _n, int _x, int _y) {
        if (_x > _y) {
            return countOfPairs(_n, _y, _x);
        }
        n = _n;
        x = _x;
        y = _y;
        int dumpCost = x == y ? 0 : 1;

        long[] output = new long[n];
        for (int i = 0; i < x; i++) {
            for (int j = i + 1; j < x; j++) {
                int dist = j - i;
                output[dist - 1] += 2;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = x; j < y; j++) {
                int dist = Math.min(j - i, x - 1 - i + dumpCost + y - 1 - j); // 先到x-1，x-1跳到y-1，y-1跳到j
                output[dist - 1] += 2;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = y; j < n; j++) {
                int dist = x - 1 - i + dumpCost + j - (y - 1);
                output[dist - 1] += 2; // 先到 x-1，再到y-1，再到j
            }
        }

        for (int i = x; i < y; i++) {
            for (int j = i + 1; j < y; j++) {
                int dist = Math.min(j - i, i - (x - 1) + dumpCost + y - 1 - j); // 先到x-1，x-1跳到y-1，y-1跳到j
                output[dist - 1] += 2;
            }
        }

        for (int i = x; i < y; i++) {
            for (int j = y; j < n; j++) {
                int dist = Math.min(j - i, i - (x - 1) + dumpCost + j - (y - 1)); // 先到x-1，x-1跳到y-1，y-1跳到j
                output[dist - 1] += 2;
            }
        }
        for (int i = y; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = j - i;
                output[dist - 1] += 2;
            }
        }

        return output;
    }

}