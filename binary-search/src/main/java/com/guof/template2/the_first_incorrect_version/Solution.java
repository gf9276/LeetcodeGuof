package com.guof.template2.the_first_incorrect_version;

//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//
//        int left = 0;
//        int right = n;
//        while (left < right) {
//            int mid = (right - left) / 2 + left;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//}