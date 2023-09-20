package com.guof.mathematics.divide;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.divide
 * Description:
 *
 * @Author guof
 * @Create 2023/5/4 20:10
 * @Version 1.0
 */
class Solution {
    public int divide(int dividend, int divisor) {

        // 特殊情况
        if (divisor == 1) return dividend; // 过
        if (divisor == -1) return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend; // -1注意一下最小值比最大值大1就好


        if (divisor == Integer.MIN_VALUE) return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        if (divisor == Integer.MAX_VALUE) {
            if (dividend == Integer.MIN_VALUE) return -1;
            if (dividend == Integer.MAX_VALUE) return 1;
        }

        boolean flag = ((dividend > 0) ^ (divisor > 0)); // 同为正，不同为负
        if (divisor > 0) divisor = -divisor; // 变成负数
        if (dividend > 0) dividend = -dividend;

        // 思路和除法算式一样的，先去凑
        int output = 0;
        while (dividend <= divisor) {
            // 被除数比除数小（负数），说明还能除
            int x = -divisor; // 变成正数
            int c = 1;
            while ((x << 1) > 0 && -(x << 1) > dividend) {
                x <<= 1;
                c += c; // 记录变化的次数，2的倍数
            }
            output += c;
            dividend += x;


        }


        return flag ? -output : output;
    }
}