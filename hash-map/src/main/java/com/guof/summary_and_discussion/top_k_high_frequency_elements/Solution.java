package com.guof.summary_and_discussion.top_k_high_frequency_elements;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }


        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((me1, me2) -> {
            return me2.getValue().compareTo(me1.getValue()); // 降序排序
        });

        System.out.println("第一种Map排序方式, 根据key排序: \n" + entryList);

        int[] output = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entryMap : entryList) {
            output[i++] = entryMap.getKey();
            if (i >= k) break;

        }
        return output;
    }

}