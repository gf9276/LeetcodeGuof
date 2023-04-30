package com.feng.mathematics.happy_number;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.happy_number
 * Description:
 *
 * @Author guof
 * @Create 2023/4/30 22:08
 * @Version 1.0
 */
class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        slow = getSum(slow);
        fast = getSum(getSum(fast));
        while (slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return slow == 1;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}