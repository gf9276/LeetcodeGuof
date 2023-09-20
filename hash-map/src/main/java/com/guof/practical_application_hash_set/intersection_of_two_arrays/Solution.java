package com.guof.practical_application_hash_set.intersection_of_two_arrays;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, false);
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, true);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i)) {
                list.add(i);
            }
        }

        int[] output = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }

        return output;
    }
}