package com.feng.linear_dp.single_string_problem_ik.egg_dropping;

class Solution {
    public int superEggDrop(int k, int n) {
        if (n <= 2) {
            return n;
        }
        // 二分最快了
        return recursion(k, 1, n, 0);

    }

    public int recursion(int k, int begin, int end, int sum) {
        if (end - begin <= 2) {
            return sum + end - begin + 1;
        }
        // 二分最快了
        else if (k == 1) {
            return recursion(k, begin + 1, end, sum + 1);
        }
        return recursion(k - 1, (end + begin + 1) / 2 + 1, end, sum + 1);
    }
}