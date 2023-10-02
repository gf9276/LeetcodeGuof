package com.guof.dp.word_splitting;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        boolean ok = false;
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                ok = true;
                dp[i] = true;
            }
        }
        if (!ok) {
            // 如果没有一个可行的，直接滚吧
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length() - 1];
    }
}