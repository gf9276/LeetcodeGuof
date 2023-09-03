package com.feng.nbr_of_options_for_buying_pens_and_pencils;


class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int cost_big = Math.max(cost1, cost2);
        int cost_small = Math.min(cost1, cost2);


        long num = 0;
        for (int i = 0; i <= total; i += cost_big) {
            num += (total - i) / cost_small + 1;
        }

        return num;

    }
}