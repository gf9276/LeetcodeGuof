package com.feng.more_practice2.finding_the_median_of_two_positively_ordered_arrays;


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int len = length1 + length2;
        if (len % 2 == 0) {
            return (getKthElement(nums1, nums2, len / 2) + getKthElement(nums1, nums2, len / 2 + 1)) / 2.0;
        } else {
            return getKthElement(nums1, nums2, len / 2 + 1) * 1.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (n < m) {  //保证nums1元素个数最小
            return getKthElement(nums2, nums1, k);
        }

        if (m == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int max = 0;


        int left = 0;
        int right = m;
        while (left < right) {
            int mid1 = (right - left) / 2 + left; // 左侧有 mid + 1 个数字
            int mid2 = k - mid1 - 2; // 左侧有 k - mid1 -1 个数字


            if (mid2 < 0) {
                // nums1的区间太大了
                right = mid1;
                continue;
            }

            int nums2_next_mid2 = mid2 + 1 == n ? Integer.MAX_VALUE : nums2[mid2 + 1];
            int nums1_next_mid1 = mid1 + 1 == m ? Integer.MAX_VALUE : nums1[mid1 + 1];

            max = Math.max(Math.min(nums1[mid1], nums2_next_mid2), Math.min(nums1_next_mid1, nums2[mid2]));

            if (nums1[mid1] < nums2[mid2]) {
                left = mid1 + 1;
            } else {
                right = mid1;
            }
        }
        return max;
    }
}