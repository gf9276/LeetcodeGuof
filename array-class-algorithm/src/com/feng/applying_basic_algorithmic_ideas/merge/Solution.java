package com.feng.applying_basic_algorithmic_ideas.merge;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 尾插法不用挪，唉
        // 特殊情况
        if (n <= 0) {
            return;
        } else if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        // 直接往后挪动
        for (int i = m + n - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }

        int idx1 = n;
        int idx2 = 0;

        for (int i = 0; i < m + n; i++) {
            if (idx1 == m + n) {
                // 如果数组1排列完了，说明后面都是数组2了
                for (int j = i; j < m + n; j++) {
                    nums1[j] = nums2[idx2++];
                }
                break;
            } else if (idx2 == n) {
                // 如果数组2排完了，后面也都不用排了
                break;
            } else if (idx1 < m + n) {
                nums1[i] = nums1[idx1] < nums2[idx2] ? nums1[idx1++] : nums2[idx2++]; // 挑选小的
            }
        }
    }
}