package com.guof.arrays_and_strings.adding_four_numbers2;

import java.util.*;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 怎么说呢？两两拆分？
        int output = 0;
        int n = nums1.length;

        Map<Integer, Integer> nums12 = new HashMap<>();
        Map<Integer, Integer> nums34 = new HashMap<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums12.put(nums1[i] + nums2[j], nums12.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                nums34.put(nums3[i] + nums4[j], nums34.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }

        for (Integer key : nums12.keySet()) {
            output += nums12.get(key) * nums34.getOrDefault(-key, 0);
        }

        return output;
    }
}