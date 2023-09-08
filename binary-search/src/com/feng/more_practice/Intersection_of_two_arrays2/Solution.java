package com.feng.more_practice.Intersection_of_two_arrays2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        List<Integer> output = new ArrayList<>();

        for (Integer key1 : map1.keySet()) {
            for (Integer key2 : map2.keySet()) {
                if (key1.equals(key2)) {
                    for (int i = 0; i < Math.min(map1.get(key1), map2.get(key2)); i++) {
                        output.add(key1);
                    }
                }
            }
        }

        int[] output2 = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            output2[i] = output.get(i);
        }

        return output2;
    }
}