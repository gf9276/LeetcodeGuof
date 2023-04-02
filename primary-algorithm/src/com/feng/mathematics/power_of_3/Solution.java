package com.feng.mathematics.power_of_3;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.power_of_3
 * Description:
 *
 * @Author guof
 * @Create 2023/4/2 22:35
 * @Version 1.0
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0) && isPowerOfThree(n / 3)); // 顺序不能错了
    }
}