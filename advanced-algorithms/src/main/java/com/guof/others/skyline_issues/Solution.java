package com.guof.others.skyline_issues;

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> output = new ArrayList<>();

        // 预处理所有的点，为了方便排序，对于左端点，令高度为负；对于右端点令高度为正
        // 因为要求起始顶点在前边，也就是左顶点在前边
        List<int[]> ps = new ArrayList<>();
        for (int[] b : buildings) {
            int l = b[0], r = b[1], h = b[2];
            ps.add(new int[]{l, -h});
            ps.add(new int[]{r, h});
        }

        // 先按照横坐标进行排序
        // 如果横坐标相同，则按照左端点排序
        // 如果相同的左/右端点，则按照高度进行排序（升序，由于左顶点是高度为负数，所以左在前）
        ps.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int preHeight = 0; // 用来兜底的

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        heap.add(preHeight);

        for (int[] p : ps) {
            int x = p[0];
            int y = p[1];

            if (y < 0) {
                // 说明是左侧点
                heap.add(-y);
            } else {
                // 说明是右侧点，说明该高度到此为止了
                heap.remove(y);
            }

            if (heap.peek() != preHeight) {
                // 如果当前高度点是第一次出现
                preHeight = heap.peek();
                output.add(new ArrayList<>(Arrays.asList(x, heap.peek())));
            }
        }
        return output;
    }
}