package com.guof.cmp_2023_12_09_119.find_intersection_values;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] output = new int[2];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        for (int j : nums2) {
            set2.add(j);
        }
        for (int j : nums1) {
            if (set2.contains(j)) {
                output[0]++;
            }
        }
        for (int j : nums2) {
            if (set1.contains(j)) {
                output[1]++;
            }
        }
        return output;
    }
}