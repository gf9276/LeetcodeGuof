package com.guof.summary_and_discussion.add_four_numbers2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                if (map.containsKey(i + j)) {
                    map.put(i + j, map.get(i + j) + 1);
                } else {
                    map.put(i + j, 1);
                }
            }
        }

        int cnt = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                sum = -sum;

                if (map.containsKey(sum)) {
                    cnt += map.get(sum);
                }
            }
        }

        return cnt;
    }
}