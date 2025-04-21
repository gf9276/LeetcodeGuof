package com.guof.start_dp.maximum_subarray_sum.lc_2606;


// leetcode 198
// 打家劫舍

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] costs = new int[26];
        for (int i = 0; i < 26; i++) {
            costs[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            int curIdx = chars.charAt(i) - 'a';
            costs[curIdx] = vals[i];
        }
        // 获取了所有的cost，开始计算最大值
        int ans = 0;
        int curNbr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curCost = costs[c - 'a']; // 获取当前数值
            curNbr = Math.max(curCost, curNbr + curCost);
            ans = Math.max(ans, curNbr);
        }
        return ans;
    }
}