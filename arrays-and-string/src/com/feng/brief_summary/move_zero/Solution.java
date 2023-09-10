package com.feng.brief_summary.move_zero;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 中心回文，简单粗暴~
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (slow <= nums.length - 1) {
            if (nums[slow] == 0) {
                while (fast <= nums.length - 1 && nums[fast] == 0) fast++;
                if (fast > nums.length - 1) break;
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }
            slow++;
            fast = Math.max(fast, slow);

        }
    }
}