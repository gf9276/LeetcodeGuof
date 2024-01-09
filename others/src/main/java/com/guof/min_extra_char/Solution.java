package com.guof.min_extra_char;


import java.util.*;

class Solution {
    Map<Integer, List<String>> map = new HashMap<>();


    public int minExtraChar(String s, String[] dictionary) {
        // 逻辑上，分割后越多、越长，效果越好
        for (String string : dictionary) {
            int size = string.length();
            if (map.containsKey(size)) {
                map.get(size).add(string);
            } else {
                map.put(size, new ArrayList<>(List.of(string)));
            }
        }

        int[] dp = new int[s.length() + 1]; // 前 n 个 字母，保留几个，下标从1开始
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 先更新一下当前的值，万一之前没有遍历到呢
                // 若 i - j > i, dp[j] + i -j 肯定大于 dp[i]，无解
                if (i - j > dp[i]) {
                    break;
                }
                dp[i] = Math.min(dp[j] + i - j, dp[i]);
            }
            for (Integer key : map.keySet()) {
                // 然后根据当前的值更新后面的值，key是长度
                if (i + key > s.length()) {
                    // 都超了，没法匹配
                    continue;
                }
                String curStr = s.substring(i, i + key);
                if (map.get(key).contains(curStr)) {
                    // 可以选择删除，表示这中间一无所有
                    dp[i + key] = Math.min(dp[i + key], dp[i]);
                }
            }
        }
        return dp[s.length()];
    }
}