package com.feng.sort_and_search.first_incorrect_version;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.first_incorrect_version
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:19
 * @Version 1.0
 */

// 没有他的API会报错

//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//        int start = 1, end = n;
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (!isBadVersion(mid))
//                start = mid + 1;
//            else
//                end = mid;
//        }
//        return start;
//    }
//
//}