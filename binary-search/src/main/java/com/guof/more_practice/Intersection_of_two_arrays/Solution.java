package com.guof.more_practice.Intersection_of_two_arrays;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);

        int[] output = new int[set1.size()];

        int j = 0;
        for (int i : set1) {
            output[j++] = i;
        }
        return output;
    }
}