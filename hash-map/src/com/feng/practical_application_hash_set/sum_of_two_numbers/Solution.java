package com.feng.practical_application_hash_set.sum_of_two_numbers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, target - i);
        }


        int[] value = new int[2];
        for (Integer key : map.keySet()) {
            if (map.containsKey(map.get(key))) {
                value[0] = key;
                value[1] = map.get(key);
                break;
            }
        }
        int[] output = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if (output[j] == -1 && value[j] == nums[i]) {
                    output[j] = i;
                    nums[i] = -9999;
                }
            }
        }
        return output;
    }
}