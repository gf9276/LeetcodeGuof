package com.guof.other.get_sum;

/**
 * ClassName: Solution
 * Package: com.feng.other.get_sum
 * Description:
 *
 * @Author guof
 * @Create 2023/5/11 15:53
 * @Version 1.0
 */
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        return getSum((a & b) << 1, a ^ b);// 进位+当前位实际的值

    }
}