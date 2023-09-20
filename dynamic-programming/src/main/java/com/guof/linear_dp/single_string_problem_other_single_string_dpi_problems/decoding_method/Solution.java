package com.guof.linear_dp.single_string_problem_other_single_string_dpi_problems.decoding_method;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        boolean decoding_not_completed;
        Map<String, Character> map = new HashMap<>();

        for (int i = 1; i < 27; i++) {
            map.put(String.valueOf(i), (char) (i + 'A' - 1));
        }

        char curC = s.charAt(0);
        if (map.containsKey(String.valueOf(curC))) {
            decoding_not_completed = true;
            dp[0] = 1;
        } else {
            decoding_not_completed = false;
            dp[0] = 0;
        }


        for (int i = 1; i < s.length(); i++) {
            char lastC = s.charAt(i - 1);
            curC = s.charAt(i); // 获取当前数字
            if (decoding_not_completed) {
                if (map.containsKey(String.valueOf(new char[]{lastC, curC}))) {
                    dp[i] += i - 2 >= 0 ? dp[i - 2] : 1;
                }
                if (map.containsKey(String.valueOf(curC))) {
                    dp[i] += dp[i - 1];
                }
                if (!map.containsKey(String.valueOf(new char[]{lastC, curC})) && !map.containsKey(String.valueOf(curC))) {
                    // 上面两种都不存在
                    decoding_not_completed = false;
                }
            } else {
                if (map.containsKey(String.valueOf(new char[]{lastC, curC}))) {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] : 1;
                    decoding_not_completed = true;
                } else {
                    // 连续两次无解，等死吧
                    return 0;
                }
            }

        }
        return dp[dp.length - 1];
    }
}