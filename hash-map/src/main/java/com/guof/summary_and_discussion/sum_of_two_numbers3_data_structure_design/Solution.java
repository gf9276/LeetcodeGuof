package com.guof.summary_and_discussion.sum_of_two_numbers3_data_structure_design;

import java.util.*;

class TwoSum {

    List<Integer> nums = new ArrayList<>();

    public TwoSum() {
    }

    public void add(int number) {
        nums.add(number);
    }

    public boolean find(int target) {
        if (nums.size() <= 1) return false;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(target - i)) {
                return true;
            }

            set.add(i);
        }

        return false;
    }
}