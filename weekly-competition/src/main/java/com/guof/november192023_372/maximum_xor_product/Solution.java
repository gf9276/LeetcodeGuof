package com.guof.november192023_372.maximum_xor_product;

class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        // x必须小于 1<<n，意味着x最多n位, 0 <= n <= 50
        // x必须在 和 a 不同 以及 和 b 不同里找一个平衡点
        int mod = 1000000009;
        if (n == 0) {
            // 0位，没意思
            return (int) ((a * b) % mod);
        }
        long range = 1;
        while (((range << 1) + 1) < (1L << n)) {
            // 获取一个范围卡
            range = (range << 1) + 1;
        }
        if (a == b) {
            long tmp = (~a) & range;
            return (int) (((tmp ^ a) * (tmp ^ a)) % mod);
        }

        long rangeA = (~a) & range;
        long rangeB = (~b) & range;

        int output = (int) (((a % mod) * (b % mod)) % mod);

        for (long i = rangeA; i > 0; i = (i - 1) & rangeA) {
            output = Math.max(output, (int) ((((a ^ i) % mod) * ((b ^ i) % mod)) % mod));
        }
        for (long i = rangeB; i > 0; i = (i - 1) & rangeB) {
            output = Math.max(output, (int) ((((a ^ i) % mod) * ((b ^ i) % mod)) % mod));
        }
        return output;
    }
}