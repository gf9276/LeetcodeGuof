package com.guof.hit_counter;


import java.util.Deque;
import java.util.LinkedList;

class HitCounter {
    Deque<Integer[]> deque = new LinkedList<>(); // {时间，次数}
    int sum = 0;

    public HitCounter() {
        // 很简单的题目，前缀和就好了，始终统计前
    }

    public void hit(int timestamp) {
        // 添加
        if (deque.isEmpty() || deque.peekLast()[0] != timestamp) {
            deque.addLast(new Integer[]{timestamp, 1});
        } else if (deque.peekLast()[0] == timestamp) {
            Integer[] tmp = deque.pollLast();
            tmp[1]++;
            deque.addLast(tmp);
        }
        sum++;
    }

    public int getHits(int timestamp) {
        // 先删除尾部
        while (!deque.isEmpty() && deque.peekFirst()[0] <= timestamp - 300) {
            sum -= deque.pollFirst()[1];
        }
        return sum;
    }
}