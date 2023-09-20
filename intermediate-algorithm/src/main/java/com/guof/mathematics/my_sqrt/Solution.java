package com.guof.mathematics.my_sqrt;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.my_sqrt
 * Description:
 *
 * @Author guof
 * @Create 2023/5/4 19:59
 * @Version 1.0
 */
class Solution {
    public int mySqrt(int x) {
        // 数值分析里应该有，不过我忘了，这里直接用二分法

        if (x == 1) {
            return 1;
        }

        double left = 0;
        double right = x;

        while (Math.abs((left + right) * (left + right) * 0.25 - x) > 0.000001) {
            if ((left + right) * (left + right) * 0.25 > x) {
                right = (left + right) * 0.5;
            } else {
                left = (left + right) * 0.5;
            }
        }
        return (int) ((right + left) * 0.5);
    }
}