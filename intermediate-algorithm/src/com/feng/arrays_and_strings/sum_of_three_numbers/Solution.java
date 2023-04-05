package com.feng.arrays_and_strings.sum_of_three_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.sum_of_three_numbers
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 17:43
 * @Version 1.0
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // 先排序
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            List<Integer> a_res = new ArrayList<>();
            int left_p = i + 1;
            int right_p = nums.length - 1;
            int need_sum = -nums[i];
            while (right_p > left_p) {
                if (nums[left_p] + nums[right_p] > need_sum) {
                    right_p--;
                } else if (nums[left_p] + nums[right_p] < need_sum) {
                    left_p++;
                } else if (nums[left_p] + nums[right_p] == need_sum) {
                    a_res.add(nums[i]);
                    a_res.add(nums[left_p]);
                    a_res.add(nums[right_p]);
                    res.add(new ArrayList<>(a_res));
                    a_res.clear();
                    while (left_p < right_p && nums[left_p] == nums[left_p + 1]) {
                        left_p++;
                    }
                    while (left_p < right_p && nums[right_p] == nums[right_p - 1]) {
                        right_p--;
                    }
                    left_p++;
                }
            }
        }
        return res;
    }
}
