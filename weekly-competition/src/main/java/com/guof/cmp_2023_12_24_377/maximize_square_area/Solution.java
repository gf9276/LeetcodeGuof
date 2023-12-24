package com.guof.cmp_2023_12_24_377.maximize_square_area;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod = 1000000007;
        // 直接就是正方形，这还不好？
        if (m == n) {
            return (int) (((long) (m - 1) * (long) (n - 1)) % mod);
        }
        // 希望我能挑个小的
        if (m < n) {
            return maximizeSquareArea(n, m, vFences, hFences);
        }
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        // 就算全是组合，也才3600个，看不起谁呢，草
        PriorityQueue<int[]> heapV = new PriorityQueue<>((a, b) -> ((b[1] - b[0]) - (a[1] - a[0])));
        PriorityQueue<int[]> heapH = new PriorityQueue<>((a, b) -> ((b[1] - b[0]) - (a[1] - a[0])));

        // 确保 1 大于 0
        getHeap(n, vFences, heapV);
        getHeap(m, hFences, heapH);

        // 开始寻找，最大正方形，理论上来讲v会比较小
        while (!heapV.isEmpty() && !heapH.isEmpty()) {
            long side1 = heapV.peek()[1] - heapV.peek()[0];
            long side2 = heapH.peek()[1] - heapH.peek()[0];
            if (side1 == side2) {
                return (int) ((side1 * side2) % mod);
            } else if (side1 > side2) {
                heapV.poll();
            } else {
                heapH.poll();
            }
        }
        return -1;
    }

    private void getHeap(int n, int[] fences, PriorityQueue<int[]> heap) {
        for (int i = -1; i < fences.length; i++) {
            for (int j = i + 1; j < fences.length + 1; j++) {
                heap.add(new int[]{i == -1 ? 1 : fences[i], j == fences.length ? n : fences[j]});
            }
        }
    }
}