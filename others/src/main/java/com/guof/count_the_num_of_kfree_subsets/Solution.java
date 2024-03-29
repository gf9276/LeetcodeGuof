package com.guof.count_the_num_of_kfree_subsets;


import java.util.*;

class Solution {

    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        long output = 1;
        // 构建一个map，map的key是 num % k, value是一个按顺序排的list，其实可以不用map，用数组就好了

        // 数据保存同余的数字
        Map<Integer, Integer>[] grps = new HashMap[k]; // 毕竟k的余数只有0~k-1，map里面是数字+次数
        for (int i = 0; i < k; i++) {
            grps[i] = new HashMap<>();
        }

        // 构建数组
        for (int num : nums) {
            grps[num % k].put(num, grps[num % k].getOrDefault(num, 0) + 1); // 统计一下次数，哈哈
        }


        // 这题目 吊啊
        for (Map<Integer, Integer> grp : grps) {
            if (grp.isEmpty()) {
                // 空的，没有意义
                continue;
            }
            // 先生成entry
            List<Map.Entry<Integer, Integer>> grpEntry = new ArrayList<>(grp.entrySet());
            grpEntry.sort((a, b) -> a.getKey() - b.getKey()); // 按照元素值升序

            long[] dp = new long[grpEntry.size() + 1]; // grp中前n个有多少个可选的子集

            dp[0] = 1; // 有一个空集合
            dp[1] = (1L << (grpEntry.get(0).getValue())); // 一个空集 + 一个数字

            for (int i = 2; i < dp.length; i++) {
                // 先不考虑数字重复的问题
                if (grpEntry.get(i - 1).getKey() - grpEntry.get(i - 2).getKey() == k) {
                    // 如果非法，只能继承上上个，选他，和上个不选他
                    dp[i] = dp[i - 2] * (1L << (grpEntry.get(i - 1).getValue() - 1)) + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] * (1L << (grpEntry.get(i - 1).getValue())); // 有  i  或者  没有  i
                }
            }
            output *= dp[grp.size()];
        }
        return output;
    }
}