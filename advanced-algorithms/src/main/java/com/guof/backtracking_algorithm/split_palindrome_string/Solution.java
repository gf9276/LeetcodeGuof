package com.guof.backtracking_algorithm.split_palindrome_string;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[][] dp;
    List<List<String>> output;
    String string;

    public List<List<String>> partition(String s) {
        output = new ArrayList<>();
        string = s;

        // 得要回溯+dp感觉，不然会超时的
        dp = new boolean[s.length()][s.length()];

        // 判断 i 到 j 是否为回文字串
        for (int right = 0; right < s.length(); right++) {
            for (int left = right; left >= 0; left--) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left <= 1) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
            }
        }

        dfs(new ArrayList<>(), 0, 0);
        return output;
    }

    public void dfs(List<String> tmp, int begin, int end) {
        if (end >= dp.length) {
            // 你逾越了，滚回去
            return;
        }

        int i = end;
        while (!dp[begin][i]) {
            i++;
            if (i >= dp.length) {
                // 你逾越了
                return;
            }
        }

        // 分两种，拿还是不拿
        // 第一种：拿
        tmp.add(string.substring(begin, i + 1));
        if (i + 1 == dp.length) {
            // 这是终点，结算一下
            output.add(new ArrayList<>(tmp));
        }
        dfs(tmp, i + 1, i + 1);
        tmp.remove(tmp.size() - 1);

        // 第二种：不拿，直接跳过i
        dfs(tmp, begin, i + 1);
    }
}