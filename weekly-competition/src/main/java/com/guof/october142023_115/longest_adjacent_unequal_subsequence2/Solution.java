package com.guof.october142023_115.longest_adjacent_unequal_subsequence2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        // 要求子序列，并且子序列相邻的数值不能一样，并且不能改变顺序
        // 这题改成汉明距离就好，限制条件变一下就行
        int[][] dp = new int[n][2];
        List<String>[][] strDp = new List[n][2];

        dp[0][0] = 0;
        dp[0][1] = words[0].length();

        strDp[0][0] = new ArrayList<>();
        strDp[0][1] = new ArrayList<>(Arrays.asList(new String[]{words[0]}));

        for (int i = 1; i < n; i++) {
            // 不拿当前的这个东西，更新dp[i][0]，选择前一个里最大的那个
            if (dp[i - 1][0] > dp[i - 1][1]) {
                dp[i][0] = dp[i - 1][0];
                strDp[i][0] = new ArrayList<>(strDp[i - 1][0]);
            } else {
                dp[i][0] = dp[i - 1][1];
                strDp[i][0] = new ArrayList<>(strDp[i - 1][1]);
            }

            // 要拿当前的东西，往前面遍历
            strDp[i][1] = new ArrayList<>(); // 先初始化一下，防止意外
            for (int j = i - 1; j >= 0; j--) {
                if (groups[j] != groups[i]) {
                    // 相同的不行，必须要不同的
                    if (words[i].length() != words[j].length() || !distOne(words[i], words[j])) {
                        // 汉明距离不为1的跳过
                        continue;
                    }
                    if (dp[j][1] > dp[i][1]) {
                        // 筛选大小
                        dp[i][1] = dp[j][1]; // 这样子更大，直接更新
                        strDp[i][1] = new ArrayList<>(strDp[j][1]);
                    }
                }
            }
            dp[i][1] += words.length; // 把自己加上
            strDp[i][1].add(words[i]); // 把自己加上
        }

        // 接下来找最大的
        int maxLen = Integer.MIN_VALUE;
        int maxLenIdx = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i][1] > maxLen) {
                maxLen = dp[i][1];
                maxLenIdx = i;
            }
        }
        return strDp[maxLenIdx][1];
    }

    public boolean distOne(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (dist == 1) {
                    return false;
                }
                dist++;
            }
        }
        return dist == 1;
    }
}