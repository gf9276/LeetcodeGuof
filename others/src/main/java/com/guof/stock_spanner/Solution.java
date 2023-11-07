package com.guof.stock_spanner;


import java.util.Deque;
import java.util.LinkedList;

class StockSpanner {

    // 一眼单调栈，该单调栈只用考虑左边，找到左边比当前点大的第一个索引即可
    Deque<Integer> stackValue = new LinkedList<>(); // 存数值
    Deque<Integer> stackIdx = new LinkedList<>(); // 存索引
    int curIdx = 0; // 记录当前索引

    public StockSpanner() {
    }

    public int next(int price) {

        while (!stackValue.isEmpty() && stackValue.peekFirst() <= price) {
            stackValue.pollFirst();
            stackIdx.pollFirst();
        }
        int lastIdx = (!stackIdx.isEmpty() ? stackIdx.peekFirst() : -1) + 1;
        stackValue.addFirst(price);
        stackIdx.addFirst(curIdx);

        curIdx++;

        return curIdx - lastIdx;
    }
}