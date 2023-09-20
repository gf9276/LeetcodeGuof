package com.guof.sort_and_search.find_peak;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.find_peak
 * Description:
 *
 * @Author guof
 * @Create 2023/4/21 19:52
 * @Version 1.0
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        while (true) {
            if (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
                idx++;
            } else {
                break;
            }
        }
        return idx;
    }
}