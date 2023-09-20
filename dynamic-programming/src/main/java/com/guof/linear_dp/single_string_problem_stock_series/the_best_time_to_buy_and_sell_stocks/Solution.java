package com.guof.linear_dp.single_string_problem_stock_series.the_best_time_to_buy_and_sell_stocks;

class Solution {
    public int maxProfit(int[] prices) {
        int output = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            output = Math.max(output, prices[i] - min);
            min = Math.min(min, prices[i]); // 更新前面的最小值
        }
        return output;
    }
}