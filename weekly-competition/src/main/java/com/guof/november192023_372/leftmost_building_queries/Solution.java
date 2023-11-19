package com.guof.november192023_372.leftmost_building_queries;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        // 显然单调栈啊
        Deque<Integer> stack = new LinkedList<>(); // 用双向队列来模拟栈，这个效率更高

        int[] rightArr = new int[heights.length]; // 统计右侧第一个比当前点高的索引

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peekFirst()]) {
                // 单调栈保持严格递减，所以要把相等的也弹出去
                stack.pollFirst();
            }
            // 如果为空则说明右侧没有比他更大的了
            rightArr[i] = !stack.isEmpty() ? stack.peekFirst() : heights.length;
            stack.addFirst(i);
        }

        int[] output = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Arrays.sort(query); // 让他有序
            if (query[0] == query[1]) {
                // 相等直接过
                output[i] = query[0];
                continue;
            }
            if (heights[query[1]] > heights[query[0]]) {
                // 如果右边的更高，也直接过
                output[i] = query[1];
                continue;
            }
            // 现在的情况就是 heights[query[1]] <= heights[query[0]]
            if (rightArr[query[0]] == heights.length) {
                // 没有相交点
                output[i] = -1;
                continue;
            }
            if (rightArr[query[0]] < query[1]) {
                // 如果还没有右边的大
                // 建议直接遍历，nnd
                int possibleIdx = rightArr[query[1]];
                while (possibleIdx < heights.length && heights[possibleIdx] <= heights[query[0]]) {
                    possibleIdx = rightArr[possibleIdx];
                }
                output[i] = possibleIdx == heights.length ? -1 : possibleIdx;
                continue;
            }
            // 现在ok了
            output[i] = rightArr[query[0]];
        }
        return output;
    }
}