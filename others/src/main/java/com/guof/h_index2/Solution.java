package com.guof.h_index2;


class Solution {
    public int hIndex(int[] citations) {
        // 既然都排好了，就是摆明着要你用二分了。。。
        // 满足数量-当前下角标 = 当前值就行了

        int left = 0;
        int right = citations.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            int curSize = citations.length - mid;

            if (curSize > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == citations.length) {
            return citations[left - 1];
        }
        return Math.min(citations[left], citations.length - left);
    }
}