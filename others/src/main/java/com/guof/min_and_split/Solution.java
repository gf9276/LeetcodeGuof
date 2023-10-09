package com.guof.min_and_split;


class Solution {
    public int splitNum(int num) {
        int[] nums = new int[10]; // 0~9
        int curNbr = num;
        int output = 0;

        while (curNbr != 0) {
            nums[curNbr % 10] += 1;
            curNbr /= 10;
        }

        int i = 9;
        int time = 1;
        int cnt = 0;
        while (i > 0) {
            if (nums[i] > 0) {
                output += i * time;
                nums[i]--;
                cnt++;
            } else {
                i--;
            }

            if (cnt == 2) {
                cnt = 0;
                time *= 10;
            }
        }

        return output;
    }
}