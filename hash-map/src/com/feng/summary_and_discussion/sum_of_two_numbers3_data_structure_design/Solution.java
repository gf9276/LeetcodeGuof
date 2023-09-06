package com.feng.summary_and_discussion.sum_of_two_numbers3_data_structure_design;

import java.util.*;

class TwoSum {

    List<Integer> nums = new ArrayList<>();

    public TwoSum() {
        nums.clear();
    }

    public void add(int number) {
        nums.add(number);
    }

    public boolean find(int target) {
        if (nums.size() <= 1) return false;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : nums) {
            map1.put(i, target - i);
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }

        for (Integer key : map1.keySet()) {
            int tmp;
            if (map2.containsKey(map1.get(key))) {
                tmp = map2.get(key);
            } else {
                continue;
            }
            if (Objects.equals(key, map1.get(key))) {
                tmp -= 2;
            } else {
                tmp -= 1;
            }
            if (tmp >= 0) {
                return true;
            }
        }
        return false;
    }
}