package com.guof.november112023_115.max_spending;


import java.util.*;

class Solution {
    public long maxSpending(int[][] values) {
        // 怎么看，怎么像归并排序
        Queue<int[]> queue = new LinkedList<>(new ArrayList<>(Arrays.asList(values)));

        while (queue.size() > 1) {
            queue.add(merge(queue.poll(), Objects.requireNonNull(queue.poll())));
        }

        long output = 0;
        int[] curValue = queue.poll();
        for (int i = 0, j = Objects.requireNonNull(curValue).length; i < curValue.length; i++, j--) {
            output += (long) j * curValue[i];
        }

        return output;
    }


    public int[] merge(int[] arr1, int[] arr2) {
        // 合并两个数组，降序排列
        int[] output = new int[arr1.length + arr2.length];
        int curIdx = 0, i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                output[curIdx++] = arr1[i++];
            } else {
                output[curIdx++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            output[curIdx++] = arr1[i++];
        }
        while (j < arr2.length) {
            output[curIdx++] = arr2[j++];
        }
        return output;
    }
}