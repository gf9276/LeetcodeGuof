package com.guof.num_teams;


class Solution {
    public int numTeams(int[] rating) {
        // 单调栈啊，感觉也不是，感觉像是 统计 i 左侧比他大的数字数+ i右侧比他小的数字数
        // 想不想并归？
        // 逆序列的那道题
        // 先用普通方法写一遍吧

        int output = 0;
        for (int i = 0; i < rating.length; i++) {
            int leftMax = 0;
            int rightMin = 0;
            int leftMin = 0;
            int rightMax = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftMin++;
                } else if (rating[j] > rating[i]) {
                    leftMax++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rightMin++;
                } else if (rating[j] > rating[i]) {
                    rightMax++;
                }
            }
            output += (leftMin * rightMax) + (leftMax * rightMin);
        }
        return output;
    }
}