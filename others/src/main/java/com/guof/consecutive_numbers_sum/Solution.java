package com.guof.consecutive_numbers_sum;


import java.util.*;

class Solution {
    public int consecutiveNumbersSum(int n) {
        // 用dp呗，卧槽，10^9次，分分钟爆炸啊
        // 挪动呗
        int output = 0;

        // 只要 2n 能除尽k不就好了嘛，k的最大值是根号2n

        for (int k = 1; k * k < 2 * n; k++) {
            if ((2 * n) % k != 0) {
                continue;
            }
            int da = (2 * n) / k - k + 1;
            if ((da + k - 1) * k / 2 == n) {
                output++;
            }
        }

        return output;
    }
}