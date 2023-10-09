package com.guof.prefix_and_optimized_dp.jump_game7;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(0) != '0' || s.charAt(s.length() - 1) != '0' || minJump > s.length() - 1) {
            // 头尾必须为0
            return false;
        }


        // 差分数组，i点可以抵达，则差分数组累积的值应该大于0
        int[] diff = new int[s.length()];
        diff[0] += 1; // 第0个点肯定可以抵达
        diff[1] -= 1;

        int nbr = 0;
        for (int i = 0; i < s.length(); i++) {
            nbr += diff[i];
            // 该点可以抵达
            if (nbr > 0 && s.charAt(i) == '0') {
                // 令区间 [i+minJump, i+maxJump] 里的点可以抵达
                if (i + minJump <= s.length() - 1) {
                    diff[i + minJump] += 1;
                }
                if (i + maxJump + 1 <= s.length() - 1) {
                    diff[i + maxJump + 1] -= 1;
                }
            }
        }

        return nbr > 0;
    }
}