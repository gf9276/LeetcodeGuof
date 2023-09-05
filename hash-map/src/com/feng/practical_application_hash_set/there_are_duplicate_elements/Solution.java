package com.feng.practical_application_hash_set.there_are_duplicate_elements;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        return set.size() != nums.length;
    }
}