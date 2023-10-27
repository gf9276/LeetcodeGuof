package com.guof.the_cake_with_the_largest_area_after_cutting;


import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        // 不是有手就行？
        long[] horizontalCutSize = new long[horizontalCuts.length + 1];
        horizontalCutSize[0] = horizontalCuts[0];
        horizontalCutSize[horizontalCutSize.length - 1] = h - horizontalCuts[horizontalCuts.length - 1];

        for (int i = 1; i < horizontalCuts.length; i++) {
            horizontalCutSize[i] = horizontalCuts[i] - horizontalCuts[i - 1];
        }

        long[] verticalCutSize = new long[verticalCuts.length + 1];
        verticalCutSize[0] = verticalCuts[0];
        verticalCutSize[verticalCutSize.length - 1] = w - verticalCuts[verticalCuts.length - 1];

        for (int i = 1; i < verticalCuts.length; i++) {
            verticalCutSize[i] = verticalCuts[i] - verticalCuts[i - 1];
        }

        Arrays.sort(horizontalCutSize);
        Arrays.sort(verticalCutSize);

        return (int) (horizontalCutSize[horizontalCutSize.length - 1] * verticalCutSize[verticalCutSize.length - 1] % 1000000007);

    }
}