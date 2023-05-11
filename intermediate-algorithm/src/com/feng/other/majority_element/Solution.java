package com.feng.other.majority_element;

/**
 * ClassName: Solution
 * Package: com.feng.other.majority_element
 * Description:
 *
 * @Author guof
 * @Create 2023/5/11 16:16
 * @Version 1.0
 */
class Solution {
    public int majorityElement(int[] nums) {
        // 排序什么的，不符合空间复杂度，摩尔投票还是很有意思的，需要两个指针

        int p = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[p] != nums[i]) {
                nums[p] = 1000000001; // 呵呵呵
                nums[i] = 1000000001; // 呵呵呵
            }
            while (nums[p] == 1000000001) {
                p++;
            }
        }

        return nums[p];
    }
}