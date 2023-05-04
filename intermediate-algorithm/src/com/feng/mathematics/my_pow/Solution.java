package com.feng.mathematics.my_pow;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.my_pow
 * Description:
 *
 * @Author guof
 * @Create 2023/5/4 19:47
 * @Version 1.0
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        double output = 1;

        if (n > 0) {
            while (n > 1) {
                if (n % 2 != 0) {
                    output *= x;
                    n -= 1;
                }
                x *= x;
                n /= 2;
            }
        } else {
            x = 1 / x;
            while (n < -1) {
                if (n % 2 != 0) {
                    output *= x;
                    n += 1;
                }
                x *= x;
                n /= 2;
            }
        }
        output *= x;

        return output;
    }
}