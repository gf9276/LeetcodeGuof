package com.guof.design_issues.shuffle_an_array;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: Solution
 * Package: com.feng.design_issues.shuffle_an_array
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 19:48
 * @Version 1.0
 */
class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums; // 直接指向那里
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] nums_shuffle = Arrays.copyOf(nums, nums.length);  // 拷贝一下
        Random r = new Random();

        for (int i = nums.length; i > 0; i--) {
            int idx = r.nextInt(i);
            int tmp = nums_shuffle[i - 1];
            nums_shuffle[i - 1] = nums_shuffle[idx];
            nums_shuffle[idx] = tmp;

        }
        return nums_shuffle;
    }
}
