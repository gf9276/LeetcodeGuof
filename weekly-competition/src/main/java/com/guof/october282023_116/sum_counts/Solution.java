package com.guof.october282023_116.sum_counts;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    int output = 0;
    int mod = 1000000007;

    public int sumCounts(List<Integer> nums) {
        // 子数组必须连续，卧槽
        // 直接强迫秒杀
        // 子数组长度，1~nums.length
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> tmp = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                tmp.add(nums.get(j));
                output += tmp.size() * tmp.size();
                output %= mod;
            }
        }
        return output;
    }
}