package com.feng.mathematics.zero_after_factorial;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.zero_after_factorial
 * Description:
 *
 * @Author guof
 * @Create 2023/4/30 22:20
 * @Version 1.0
 */
class Solution {
    public int trailingZeroes(int n) {
        // 求 2*5 的数量是吧
        // 由于2的数量远少于5，所以就是求5的数量
        // 5 的数量怎么求呢，简单的方法就是一个个算，但是这并不合理
        // 5这个数字吧，每5个就会出现至少一个

        // 一步步来，先计算是5倍数的数量，再计算是25倍数的数量，再计算是125倍数的数量。。。
        int sum = 0;
        while (n > 0) {
            n /= 5;
            sum += n;
        }
        return sum;
    }
}