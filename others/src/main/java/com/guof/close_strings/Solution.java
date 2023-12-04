package com.guof.close_strings;


import java.util.PriorityQueue;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // 替换两者位置或者替换两者所有的位置
        char[] tmp1 = word1.toCharArray();
        char[] tmp2 = word2.toCharArray();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        // 统计一下分布

        for (char c : tmp1) {
            cnt1[c - 'a']++;
        }
        for (char c : tmp2) {
            cnt2[c - 'a']++;
        }
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>();
        for (int i = 0; i < cnt1.length; i++) {
            if ((cnt1[i] == 0 && cnt2[i] != 0) || (cnt1[i] != 0 && cnt2[i] == 0)) {
                return false;
            }
            if (cnt1[i] == 0 && cnt2[i] == 0) {
                continue;
            }
            heap1.add(cnt1[i]);
            heap2.add(cnt2[i]);
        }
        while (!heap1.isEmpty()) {
            if (!heap1.poll().equals(heap2.poll())) {
                return false;
            }
        }
        return true;
    }
}