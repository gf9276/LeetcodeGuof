package com.feng.double_index_technique_colliding_pointers.max_area;

/**
 * ClassName: Solution
 * Package: com.feng.double_index_technique_colliding_pointers.max_area
 * Description:
 *
 * @Author guof
 * @Create 2023/5/16 12:49
 * @Version 1.0
 */
class Solution {
    public int maxArea(int[] height) {
        int leftP = 0;
        int rightP = height.length - 1;
        int maxAreaValue = Math.min(height[rightP], height[leftP]) * (rightP - leftP);

        while (leftP < rightP) {
            if (height[rightP] < height[leftP]) {
                rightP--;
            } else {
                leftP++;
            }
            maxAreaValue = Math.max(maxAreaValue, Math.min(height[rightP], height[leftP]) * (rightP - leftP));
        }
        return maxAreaValue;
    }
}
