package com.guof.max_altitude;


import java.util.PriorityQueue;

class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        if (limit == 0) {
            // 骗子，骗我limit>=1
            return new int[0];
        }
        // 这玩意感觉不难啊
        // 直接 heap + 滑动窗口，秒杀
        int[] output = new int[heights.length - limit + 1];
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]); // 最大堆

        int right = 0; // limit 小于等于height.length，且大于等于1
        for (; right < limit; right++) {
            heap.add(new Integer[]{right, heights[right]});
        }

        for (int left = 0; left < output.length; left++, right++) {
            // 提取出区间里最大的值，就是视野内最高的楼
            while (heap.peek()[0] < left) {
                // 最高楼算自己的，所以只需要踢掉在自己前面的就行
                heap.poll();
            }
            output[left] = heap.peek()[1];

            // 添加新的最高楼，有新楼就添加咯
            if (right < heights.length) {
                heap.add(new Integer[]{right, heights[right]});
            }
        }
        return output;
    }
}