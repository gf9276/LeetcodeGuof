package com.guof.practical_application_hash_mapping.there_are_duplicate_elements2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}