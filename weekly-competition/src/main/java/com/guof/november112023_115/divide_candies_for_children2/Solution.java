package com.guof.november112023_115.divide_candies_for_children2;


class Solution {
    public long distributeCandies(int n, int limit) {
        long output = 0;
        // 先固定一个，另外两个再分？
        for (long i = 0; i <= limit; i++) {
            long remainingCandies = n - i;
            if (remainingCandies < 0) {
                // 糖果分完了
                break;
            }
            long oneCandies = Math.min(remainingCandies, limit); // 其中一个人能拿到的最多糖果
            long anotherCandies = remainingCandies - oneCandies; // 另外一个人能拿到的最多糖果
            output += Math.max(0, oneCandies - anotherCandies + 1); // 排除异常情况，分不完的情况
        }
        return output;
    }
}