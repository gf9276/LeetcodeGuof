package com.guof.dp.word_splitting2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<StringBuilder>[] dp = new ArrayList[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }


        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                StringBuilder tmpSb = new StringBuilder();
                tmpSb.append(s, 0, i + 1);
                dp[i].add(tmpSb);
            }
        }

        List<String> output = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j + 1, i + 1))) {
                    for (StringBuilder sb : dp[j]) {
                        StringBuilder tmpSb = new StringBuilder(sb);
                        tmpSb.append(" ").append(s, j + 1, i + 1);
                        dp[i].add(tmpSb);
                    }
                }
            }
        }

        for (StringBuilder sb : dp[s.length() - 1]) {
            output.add(sb.toString());
        }
        return output;
    }
}