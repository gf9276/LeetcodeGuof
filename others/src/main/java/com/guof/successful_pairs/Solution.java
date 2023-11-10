package com.guof.successful_pairs;


import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] output = new int[spells.length];
        // 二分肯定不会超时，呵呵呵
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long curSpell = spells[i];
            int left = 0;
            int right = potions.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if ((long) potions[mid] * curSpell < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            output[i] = potions.length - left;
        }
        return output;
    }
}