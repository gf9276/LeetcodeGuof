package com.guof.sort_and_search.the_kth_largest_element_in_the_array;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.the_kth_largest_element_in_the_array
 * Description:
 *
 * @Author guof
 * @Create 2023/4/18 14:38
 * @Version 1.0
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);//先排序
        return nums[nums.length - k];//在查找
    }
}