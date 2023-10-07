package com.guof.stock_price_span;


import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    List<Integer> dp;
    List<Integer> prices;

    public StockSpanner() {
        // 这题像是那个，归并排序，逆序对
        // 但也不像，因为要求连续
        // 不过这题不难
        dp = new ArrayList<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        int lastIdx = dp.size() - 1;

        if (lastIdx < 0 || prices.get(lastIdx) > price) {
            dp.add(1);
            prices.add(price);
            return 1;
        }

        int curDp = dp.get(lastIdx);
        lastIdx -= curDp; // 找到第一个大的

        while (lastIdx >= 0 && prices.get(lastIdx) <= price) {
            curDp++;
            lastIdx--;
        }
        curDp += 1; // 加上自己

        dp.add(curDp);
        prices.add(price);
        return curDp;
    }
}