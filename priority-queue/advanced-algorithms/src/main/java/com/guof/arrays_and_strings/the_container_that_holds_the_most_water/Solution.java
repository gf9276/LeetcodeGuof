package com.guof.arrays_and_strings.the_container_that_holds_the_most_water;

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
    public int maxArea(int[] height) {
        // 我是一头猪，mlgbd 草

        int left = 0;
        int right = height.length - 1;
        int output = 0;

        while (left < right) {
            int curHeight = Math.min(height[left], height[right]);
            output = Math.max(output, curHeight * (right - left));

            if (height[left] > height[right]) {
                right--;
            } else{
                left++;
            }
        }
        return output;
    }
}