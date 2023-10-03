package com.guof.sort_and_search.the_kth_smallest_element_in_an_ordered_matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 长这样子，很难不相信你是归并排序。。。
        Queue<Integer[]> queue = new LinkedList<>();
        for (int[] tmp : matrix) {
            queue.add(Arrays.stream(tmp).boxed().toArray(Integer[]::new));
        }

        while (queue.size() > 1) {
            Integer[] matrix1 = queue.poll();
            Integer[] matrix2 = queue.poll();
            queue.add(merge2Arr(matrix1, matrix2));
        }

        return queue.peek()[k - 1];
    }

    public Integer[] merge2Arr(Integer[] matrix1, Integer[] matrix2) {
        Integer[] output = new Integer[matrix1.length + matrix2.length];

        int matrix1Idx = 0;
        int matrix2Idx = 0;
        int outputIdx = 0;
        while (matrix1Idx < matrix1.length && matrix2Idx < matrix2.length) {
            if (matrix1[matrix1Idx] < matrix2[matrix2Idx]) {
                output[outputIdx++] = matrix1[matrix1Idx++];
            } else {
                output[outputIdx++] = matrix2[matrix2Idx++];
            }
        }

        while (matrix1Idx < matrix1.length) {
            output[outputIdx++] = matrix1[matrix1Idx++];
        }
        while (matrix2Idx < matrix2.length) {
            output[outputIdx++] = matrix2[matrix2Idx++];
        }

        return output;
    }
}