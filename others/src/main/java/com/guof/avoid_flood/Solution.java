package com.guof.avoid_flood;


import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] output = new int[rains.length];
        Arrays.fill(output, -1);
        List<Integer> noRainList = new ArrayList<>(); // 按顺序记录晴天日期
        Map<Integer, Integer> lastRainDayMap = new HashMap<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                // 记录晴天日期
                noRainList.add(i);
                output[i] = 1;
            } else {
                // 下雨吧
                int poolIdx = rains[i] - 1;
                if (lastRainDayMap.containsKey(poolIdx)) {
                    // 如果已经满了，lastRainDayMap肯定有相关信息，记录上一次下雨的日子
                    int lastRainDay = lastRainDayMap.get(poolIdx);
                    // 然后再去noRainList里面找，在lastRainDay之后的第一个晴天，找不到等死吧
                    // 用左闭右开找
                    int left = 0;
                    int right = noRainList.size();
                    if (right == 0 || noRainList.get(right - 1) < lastRainDay) {
                        // 没有晴天 或者 晴天在上次下雨天之前
                        return new int[0];
                    }
                    while (left < right) {
                        int mid = (right - left) / 2 + left;
                        if (noRainList.get(mid) >= lastRainDay) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                    output[noRainList.get(left)] = rains[i];
                    noRainList.remove(left);
                }
                lastRainDayMap.put(poolIdx, i); // 记录最近一次下雨的日子
            }
        }
        return output;
    }
}