package com.guof.my_calendar_three;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MyCalendarThree {
    // 不是我说，这题一股前缀和的味道，难崩
    Map<Integer, Integer> map = new HashMap<>();

    public MyCalendarThree() {

    }

    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int output = 0;
        int sum = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(map.keySet());
        while (!heap.isEmpty()) {
            sum += map.get(heap.poll());
            output = Math.max(sum, output);
        }
        return output;
    }
}