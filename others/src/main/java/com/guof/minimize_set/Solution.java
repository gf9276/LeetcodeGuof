package com.guof.minimize_set;


class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long commonMultiple = lcm(divisor1, divisor2); // 求公倍数
        long left = 1;
        long right = (uniqueCnt1 + uniqueCnt2) * 2; // 最坏情况下，divisor1 = divisor2 = 2，此时可能需要这么多个数字

        // [left, right]是一个闭区间，答案output可能在这中间，x表示数字的个数 = right + 1
        // 其中属于unique1的有 x/d2 - x/cm 个 给u1
        // 其中属于unique2的有 x/d1 - x/cm 个 给u2
        // 那么剩下的就是大家都有的

        long output = right;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long u1 = mid / divisor2 - mid / commonMultiple;
            long u2 = mid / divisor1 - mid / commonMultiple;
            long u1u2 = mid - u1 - u2 - mid / commonMultiple; // 剩下的大家都可以用

            // 下面只要判断够不够用就行了
            // 或者说是不是多了，多了就right = mid - 1;
            // 少了就left = mid+1;

            // 补全操作
            if (u1 < uniqueCnt1) {
                u1u2 -= (uniqueCnt1 - u1);
                u1 = uniqueCnt1;
            }
            if (u2 < uniqueCnt2) {
                u1u2 -= (uniqueCnt2 - u2);
                u2 = uniqueCnt2;
            }


            if (u1u2 == 0 && (u1 == uniqueCnt1 || u2 == uniqueCnt2)) {
                output = Math.min(output, mid);
                right = mid - 1;
            } else if (u1u2 < 0) {
                // 不够了
                left = mid + 1;
            } else {
                // 多了
                right = mid - 1;
            }
        }
        return (int) output;
    }

    public static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        a = max;
        b = min;
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static long lcm(int a, int b) {
        return ((long) a * b / gcd(a, b));
    }
}