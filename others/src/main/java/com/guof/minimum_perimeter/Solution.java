package com.guof.minimum_perimeter;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public long minimumPerimeter(long neededApples) {
        long n = 0; // 半边长
        while (4 * n * n * n + 6 * n * n + 2 * n < neededApples) {
            n++;
        }
        return n * 8L;
    }
}
// 0 12 48 108 192 300 432 588
// 0 2  4  6   8   10  12  14
// 每次变化 12(n+1) n是当前边长