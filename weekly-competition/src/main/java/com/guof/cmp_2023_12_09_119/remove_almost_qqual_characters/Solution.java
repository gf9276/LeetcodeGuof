package com.guof.cmp_2023_12_09_119.remove_almost_qqual_characters;

class Solution {
    public int removeAlmostEqualCharacters(String word) {
        // 保证前n个字母是合法的
        int n = word.length();
        int[][] dp = new int[n][2]; // 1是变成万能符号的修改次数
        dp[0][1] = 1;  // 改成万能位置

        // 从1开始，0不用改
        for (int i = 1; i < n; i++) {
            // 反正不冲突，无所谓
            if (word.charAt(i) == word.charAt(i - 1) || Math.abs(word.charAt(i) - word.charAt(i - 1)) == 1) {
                // 相等或者相邻，必须改了
                dp[i][0] = dp[i - 1][1]; // 后一个不改，前一个必须改
            } else {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // 反正不冲突，无所谓
            }
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1; // 前一个改不改无所谓的
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}