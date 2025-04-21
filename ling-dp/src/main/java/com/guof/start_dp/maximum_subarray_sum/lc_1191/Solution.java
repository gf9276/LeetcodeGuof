package com.guof.start_dp.maximum_subarray_sum.lc_1191;


// leetcode 1191

import java.lang.reflect.Array;

// 情况3, 超过2个，可以作为头和尾 当sum大于零时，注意到除去第一次和最后一次串连，其余每次串联的arr[i]均对最大和有贡献，因此返回
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1000000007;
        long maxAns = 0L;
        long curNbr = 0L;
        long n = arr.length;

        for (long i = 0; i < n; i++) {
            curNbr = Math.max(arr[(int) (i % n)] + curNbr, arr[(int) (i % n)]);
            maxAns = Math.max(maxAns, curNbr);
        }
        if (k == 1) {
            return (int) (maxAns % MOD);
        }

        // 超过2了
        long oneSum = 0L;
        for (int i : arr) {
            oneSum += i;
        }


        curNbr = 0L;
        for (long i = 0; i < 2 * n; i++) {
            curNbr = Math.max(arr[(int) (i % n)] + curNbr, arr[(int) (i % n)]);
            maxAns = Math.max(maxAns, curNbr);
        }
        maxAns = Math.max(maxAns, maxAns + (k - 2) * oneSum);
        maxAns = Math.max(oneSum * k, maxAns);

        return (int) (maxAns % MOD);
    }
}