package com.guof.arrays_and_strings.find_duplicates;

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
    public int findDuplicate(int[] nums) {
        // 这题目碰见这么多次，我要是还不会写，我不如去吃屎
        // 我是傻逼
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if (fast == slow) {
                break;
            }
        }
        // 现在已经进环了
        slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (fast == slow) {
                return fast;
            }
        }
    }
}