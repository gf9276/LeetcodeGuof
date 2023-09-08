package com.feng.template_analysis.search_for_ordered_arrays_with_unknown_length;


//class Solution {
//    public int search(ArrayReader reader, int target) {
//        int left = 0;
//        int right = Integer.MAX_VALUE;
//
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            if (reader.get(mid) == target) {
//                return mid;
//            }
//
//            if (target < reader.get(mid)) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }
//}