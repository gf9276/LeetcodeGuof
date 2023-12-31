package com.guof.cmp_2023_12_31_378.can_make_palindrome_queries;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        boolean[] output = new boolean[queries.length];
        return output;
    }

//    public boolean canEqual(String s, int[] query) {
//        // 判断query范围内的数字能不能形成回文串
//        int n = s.length(); // 字符串长度
//        if (n - 1 - query[0] <= query[2] || n - 1 - query[1] >= query[3]) {
//            // 右侧在左侧，或者左侧在右侧，就是没有重叠
//            // 此时比对区间内的字母是否相同即可
//            Set<Character> set1 = new HashSet<>();
//            Set<Character> set2 = new HashSet<>();
//            Set<Character> set3 = new HashSet<>();
//            Set<Character> set4 = new HashSet<>();
//            for (int i = query[0]; i <= query[1]; i++) {
//                set1.add(s.charAt(i));
//                set2.add(s.charAt(n - 1 - i));
//            }
//            for (int i = query[2]; i <= query[3]; i++) {
//                set3.add(s.charAt(i));
//                set4.add(s.charAt(n - 1 - i));
//            }
//            return set1.containsAll(set2) && set3.containsAll(set4);
//        } else if (n - 1 - query[0] >= query[3] && n - 1 - query[1] <= query[2]) {
//            // 包容情况，左侧更大
//            Set<Character> set1 = new HashSet<>();
//            Set<Character> set2 = new HashSet<>();
//            for (int i = query[0]; i <= query[1]; i++) {
//                set1.add(s.charAt(i));
//                set2.add(s.charAt(n - 1 - i));
//            }
//            return set1.containsAll(set2);
//        } else if (n - 1 - query[0] <= query[3] && n - 1 - query[1] >= query[2]) {
//            // 右侧更大
//            Set<Character> set3 = new HashSet<>();
//            Set<Character> set4 = new HashSet<>();
//            for (int i = query[2]; i <= query[3]; i++) {
//                set3.add(s.charAt(i));
//                set4.add(s.charAt(n - 1 - i));
//            }
//            return set3.containsAll(set4);
//        } else {
//            // 重叠了，唉
//            if ()
//        }
//    }
}