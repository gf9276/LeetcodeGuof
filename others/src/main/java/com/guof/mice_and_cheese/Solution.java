package com.guof.mice_and_cheese;


import java.util.PriorityQueue;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // dp会超时欸，不如遍历，我真聪明
        int output = 0;
        for (int i = 0; i < reward1.length; i++) {
            output += reward2[i];
        }
        if (k == 0) {
            return output;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 最小堆

        for (int i = 0; i < reward1.length; i++) {
            if (heap.size() < k) {
                heap.add(reward1[i] - reward2[i]);
            } else {
                if (reward1[i] - reward2[i] > heap.peek()) {
                    heap.poll();
                    heap.add(reward1[i] - reward2[i]);
                }
            }
        }

        while (!heap.isEmpty()) {
            output += heap.poll();
        }
        return output;
    }
}