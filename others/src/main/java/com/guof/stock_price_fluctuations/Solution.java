package com.guof.stock_price_fluctuations;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class StockPrice {
    PriorityQueue<Integer[]> maxPriceHeap;
    PriorityQueue<Integer[]> minPriceHeap;
    PriorityQueue<Integer> stampHeap;
    Map<Integer, Integer> priceMap;

    public StockPrice() {
        stampHeap = new PriorityQueue<>((a, b) -> b - a); // 最大堆，时间戳越大排的越靠前
        maxPriceHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]); // 最大堆
        minPriceHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 最小堆
        priceMap = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        // 如果这个时间戳是新的，那就加入时间戳
        if (!priceMap.containsKey(timestamp)) {
            stampHeap.add(timestamp);
        }
        maxPriceHeap.add(new Integer[]{timestamp, price});
        minPriceHeap.add(new Integer[]{timestamp, price});
        priceMap.put(timestamp, price);
    }

    public int current() {
        return priceMap.get(stampHeap.peek());
    }

    public int maximum() {
        while (!Objects.equals(priceMap.get(maxPriceHeap.peek()[0]), maxPriceHeap.peek()[1])) {
            maxPriceHeap.poll();
        }

        return maxPriceHeap.peek()[1];
    }

    public int minimum() {
        while (!Objects.equals(priceMap.get(minPriceHeap.peek()[0]), minPriceHeap.peek()[1])) {
            minPriceHeap.poll();
        }

        return minPriceHeap.peek()[1];
    }
}