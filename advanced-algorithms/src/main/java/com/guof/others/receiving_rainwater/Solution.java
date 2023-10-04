package com.guof.others.receiving_rainwater;

class Solution {
    public int trap(int[] height) {
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1], height[i + 1]);
        }

        int output = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(dpLeft[i], dpRight[i]);
            if (minHeight > height[i]) {
                output += minHeight - height[i];
            }
        }
        return output;
    }
}