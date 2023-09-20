package com.guof.make_initial_definitions.remove_duplicates;

/**
 * ClassName: Solution
 * Package: com.feng.make_initial_definitions.remove_duplicates
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 20:52
 * @Version 1.0
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // 我觉得可以往前插入
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len < 2 || nums[i] != nums[len - 2]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}