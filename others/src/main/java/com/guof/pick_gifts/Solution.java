package com.guof.pick_gifts;


import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        for (int gift : gifts) {
            heap.add(gift);
        }
        for (int i = 0; i < k; i++) {
            heap.add((int) (Math.sqrt((double) heap.poll())));
        }

        long output = 0;
        while (!heap.isEmpty()) {
            output += heap.poll();
        }
        return output;
    }
}