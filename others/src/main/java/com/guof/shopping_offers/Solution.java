package com.guof.shopping_offers;


import java.util.ArrayList;
import java.util.List;

class Solution {
    int output = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        output = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> gift = special.get(i);
            int priceSum = 0;
            for (int j = 0; j < needs.size(); j++) {
                priceSum += price.get(j) * gift.get(j); // 单买的价格
            }
            if (gift.get(needs.size()) >= priceSum) {
                // 垃圾礼包留着过年？
                special.remove(i);
                i--;
            }
        }
        if (special.isEmpty()) {
            // 送你一个，做兼容嘻嘻
            List<Integer> tmp = new ArrayList<>();
            for (Integer need : needs) {
                tmp.add(need + 1);
            }
            special.add(tmp);
        }
        List<Integer> curNbr = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            curNbr.add(0);
        }
        dfs(price, special, needs, curNbr, 0);
        return output;
    }

    public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, List<Integer> curNbr, int curPrice) {
        // curNbr和needs同维度

        for (List<Integer> gift : special) {
            boolean end = false;
            List<Integer> nextNbr = new ArrayList<>(curNbr);
            for (int i = 0; i < nextNbr.size(); i++) {
                // 超出了
                nextNbr.set(i, nextNbr.get(i) + gift.get(i));
                if (nextNbr.get(i) > needs.get(i)) {
                    end = true;
                }
            }
            if (end) {
                int endPrice = curPrice;
                for (int i = 0; i < curNbr.size(); i++) {
                    endPrice += price.get(i) * (needs.get(i) - curNbr.get(i));
                }
                output = Math.min(output, endPrice);
            } else {
                dfs(price, special, needs, nextNbr, curPrice + gift.get(needs.size()));
            }
        }
    }
}