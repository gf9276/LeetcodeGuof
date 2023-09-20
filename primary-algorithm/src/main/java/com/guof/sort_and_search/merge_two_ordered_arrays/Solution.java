package com.guof.sort_and_search.merge_two_ordered_arrays;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.merge_two_ordered_arrays
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 21:53
 * @Version 1.0
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx_m = 0;
        int idx_n = 0;
        int[] tmp_array = new int[m + n];
        int tmp_array_idx = 0;
        while (idx_m < m && idx_n < n) {
            if (nums1[idx_m] < nums2[idx_n]) {
                tmp_array[tmp_array_idx++] = nums1[idx_m++];
            } else {
                tmp_array[tmp_array_idx++] = nums2[idx_n++];
            }
        }
        for (; idx_m < m; idx_m++) {
            tmp_array[tmp_array_idx++] = nums1[idx_m];
        }
        for (; idx_n < n; idx_n++) {
            tmp_array[tmp_array_idx++] = nums2[idx_n];
        }

        System.arraycopy(tmp_array, 0, nums1, 0, m + n);
    }
}