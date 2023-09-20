package com.guof.practical_application_hash_mapping.the_minimum_index_sum_of_two_lists;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            String string = list2[i];
            if (map.containsKey(string)) {
                map2.put(string, map.get(string) + i);
            }
        }

        int min_idx = Integer.MAX_VALUE;
        for (String i : map2.keySet()) {
            min_idx = Math.min(min_idx, map2.get(i));
        }

        List<String> output = new ArrayList<>();

        for (String i : map2.keySet()) {
            if (min_idx == map2.get(i)) {
                output.add(i);
            }
        }
        return output.toArray(new String[0]);
    }
}