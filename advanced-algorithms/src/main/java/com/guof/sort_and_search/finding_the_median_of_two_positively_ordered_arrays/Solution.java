package com.guof.sort_and_search.finding_the_median_of_two_positively_ordered_arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge2Arr(nums1, nums2);
        if ((nums1.length + nums2.length) % 2 == 1) {
            return arr[(nums1.length + nums2.length) / 2];
        } else {
            return 0.5 * (arr[(nums1.length + nums2.length) / 2] + arr[(nums1.length + nums2.length - 1) / 2]);
        }
    }

    public int[] merge2Arr(int[] matrix1, int[] matrix2) {
        int[] output = new int[matrix1.length + matrix2.length];

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