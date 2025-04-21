package com.guof.state_machine_dp.buy_and_sell_stocks.lc_121;

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i : prices) {
            min = Math.min(min, i);
            ans = Math.max(ans, i - min);
        }
        return ans;
    }
}