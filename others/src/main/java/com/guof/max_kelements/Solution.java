package com.guof.max_kelements;


import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // 我个人认为，有高分不选就是傻子
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        heap.addAll(Arrays.stream(nums).boxed().toList());

        long output = 0;
        while (k > 0) {
            k--;
            int curScore = heap.poll();
            output += curScore;
            heap.add(ceilDivide(curScore));
        }
        return output;
    }


    public int ceilDivide(int num) {
        return num / 3 + (num % 3 == 0 ? 0 : 1);
    }
}