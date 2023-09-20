package com.guof.linear_dp.single_string_problem_ik.flip_a_coin;

import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        if (target == 0) {
            double output = 1 - prob[0];
            for (int i = 1; i < prob.length; i++) {
                output *= (1 - prob[i]);
            }
            return output;
        }

        double[][] dp = new double[2][target + 1];
        int curIdx = 0;
        int lastIdx = curIdx;
        dp[curIdx][0] = 1 - prob[0];
        dp[curIdx][1] = prob[0];
        curIdx = (curIdx + 1) % 2;

        for (int i = 1; i < prob.length; i++) {
            // 都不超上直接累乘就好了
            dp[curIdx][0] = dp[lastIdx][0] * (1 - prob[i]);
            for (int j = 1; j < dp[curIdx].length; j++) {
                // 当前j个朝上的概率为上一个j-1朝上概率*当前朝上 + 上一个j朝上概率*当前不朝上
                dp[curIdx][j] = dp[lastIdx][j - 1] * prob[i] + dp[lastIdx][j] * (1 - prob[i]);
            }
            lastIdx = curIdx;
            curIdx = (curIdx + 1) % 2;
        }
        return dp[lastIdx][target];
    }
}