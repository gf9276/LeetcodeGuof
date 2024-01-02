package com.guof.get_max_repetitions;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 10的6次啊，找一个循环的圈圈？

        // s2的第i个字符，出现在了以前出现过的位置，是这样子的
        // 就检查第一个呗

        Map<Integer, Integer> map1 = new HashMap<>(); // 记录第一次出现的位置
        Map<Integer, Integer> map2 = new HashMap<>(); // 记录第一次出现时的个数
        int s2Idx = 0;
        int curN = 0; // 完整走完了几个？
        for (int i = 0; i < s1.length() * n1; i++) {
            if (s2.charAt(s2Idx) != s1.charAt(i % s1.length())) {
                // 不一样就划过
                continue;
            }
            if (s2Idx == 0 && map1.containsKey(i % s1.length())) {
                // 开头终于重复了
                int moveI = i - map1.get(i % s1.length()); // 移动了几个i
                int moveN = curN - map2.get(i % s1.length()); // 移动了几个n
                int maxCir = (s1.length() * n1 - i) / moveI; // 还能走几个i
                maxCir = Math.max(0, maxCir - 1); // 少一个，安全
                i += maxCir * moveI;
                curN += maxCir * moveN;
            } else if (s2Idx == 0) {
                // 只保存0对应的
                map1.put(i % s1.length(), i);
                map2.put(i % s1.length(), curN);
            }
            // 一样了
            s2Idx++;
            if (s2Idx == s2.length()) {
                curN++;
                s2Idx = 0;
            }
        }

        // s2循环n次了
        return curN / n2;
    }
}