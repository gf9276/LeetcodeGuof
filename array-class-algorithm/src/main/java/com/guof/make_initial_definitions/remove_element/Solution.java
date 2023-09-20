package com.guof.make_initial_definitions.remove_element;

/**
 * ClassName: Solution
 * Package: com.feng.make_initial_definitions.remove_element
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 17:01
 * @Version 1.0
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        // 很简单，直接互换位置就可以了
        int cnt = 0;
        int idx = nums.length - 1; // 倒着来
        while (idx >= 0 && nums[idx] == val) {
            // 找到第一个不是val的位置
            idx--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (idx < i) {
                break;
            }
            if (val == nums[i]) {
                // 出现相等
                int tmp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = tmp;
                while (idx >= 0 && nums[idx] == val) {
                    // 找到第一个不是val的位置
                    idx--;
                }
            }
            cnt++; // 计数
        }
        return cnt;
    }
}