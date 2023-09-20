package com.guof.linear_dp.single_string_problem_ik.egg_dropping;

class Solution {
    public int superEggDrop(int k, int n) {
        // 很强的做法
        int t = 1;
        while (calcF(k, t) < n + 1) t++;
        return t;
    }

    public int calcF(int k, int t) {
        if (t == 1 || k == 1) return t + 1;
        return calcF(k - 1, t - 1) + calcF(k, t - 1);
    }
}