package com.feng.dynamic_programming.the_best_time_to_buy_and_sell_stocks.the_best_time_to_buy_and_sell_stocks;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.the_best_time_to_buy_and_sell_stocks
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:30
 * @Version 1.0
 */
class Solution {
    public static int maxProfit(int[] prices) {
        // 这种思路很简单
        int maxProfit = 0;
        int minValue = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }

}