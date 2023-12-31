package com.guof.cmp_2023_12_31_378.maximum_length;

import java.util.*;

class Solution {
    public int maximumLength(String s) {
        // 统计最长字串的个数
        // 首先，你要知道，小的永远包裹在大的里面，所以，只需要记录连续长度最大的就行
        // 所以只统计大的就可以了
        Map<String, Integer> map = new HashMap<>();
        s = s + "#"; // 加个结束符

        StringBuilder stringBuilder = new StringBuilder(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            // 和上一个字母不一样了，或者到终点了，那就把这个连续字串加进来
            if (s.charAt(i) != s.charAt(i - 1)) {
                // 记录这个连续字符串
                map.put(stringBuilder.toString(),
                        map.getOrDefault(stringBuilder.toString(), 0) + 1);
                // 更换新的连续字符串
                stringBuilder = new StringBuilder(String.valueOf(s.charAt(i)));
            } else {
                // 连续字符串还在连续！
                stringBuilder.append(s.charAt(i));
            }
        }

        // 需要排序一下
        PriorityQueue<String> mapKeys = new PriorityQueue<>((a, b) -> b.length() - a.length());
        mapKeys.addAll(new ArrayList<>(map.keySet()));

        while (!mapKeys.isEmpty()) {
            String key = mapKeys.poll();
            Integer value = map.get(key);
            if (value >= 3) {
                // 后面只会更小，既然你符合条件，那直接就是你了!
                return key.length();
            }

            String nextKey = key.substring(0, key.length() - 1); // 去掉尾巴
            for (int j = 0; j < 2 && !nextKey.isEmpty(); j++) {
                // 最多两次，因为掐掉两次之后，已经有3了
                if (!map.containsKey(nextKey)) {
                    // 不存在就加入
                    mapKeys.add(nextKey);
                }
                map.put(nextKey, map.getOrDefault(nextKey, 0) + value * (key.length() - nextKey.length() + 1));
                nextKey = nextKey.substring(0, nextKey.length() - 1);
            }
        }
        return -1;
    }
}