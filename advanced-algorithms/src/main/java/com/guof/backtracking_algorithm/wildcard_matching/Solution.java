package com.guof.backtracking_algorithm.wildcard_matching;

//class Solution {
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) {
//            return s.isEmpty();
//        }
//        if (p.equals("*")) {
//            return true;
//        }
//        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
//
//    }
//
//
//    public boolean dfs(char[] s, char[] p, int sIdx, int pIdx) {
//        if (sIdx == s.length && pIdx == p.length) {
//            // 同时抵达中点，成功！
//            return true;
//        } else if (pIdx == p.length) {
//            // 不同步，不行
//            return false;
//        } else if (sIdx == s.length) {
//            // * 可以匹配空气。。。
//            while (p[pIdx] == '*') {
//                pIdx++;
//                if (pIdx == p.length) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        boolean result = false;
//        if (p[pIdx] != '*' && p[pIdx] != '?') {
//            if (p[pIdx] != s[sIdx]) {
//                // 配不上
//                return false;
//            } else {
//                // 配上了
//                result |= dfs(s, p, sIdx + 1, pIdx + 1);
//            }
//        } else if (p[pIdx] == '?') {
//            // 配上了
//            result |= dfs(s, p, sIdx + 1, pIdx + 1);
//        } else if (p[pIdx] == '*') {
//            // 选择动或者不动
//            result |= dfs(s, p, sIdx + 1, pIdx); // 匹配多个字符
//            result |= dfs(s, p, sIdx + 1, pIdx + 1); // 匹配一个字符
//            result |= dfs(s, p, sIdx, pIdx + 1); // 鸟都不匹配
//        }
//
//        return result;
//    }
//}

class Solution {
    public boolean isMatch(String s, String p) {
        // s的前i个是否和p的前j个匹配
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] = true; // 吊都没有，自然匹配

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                // 若为*，一配配所有，* 无敌
                if (p.charAt(i - 1) == '*' && dp[i - 1][j]) {
                    for (int k = j; k <= s.length(); k++) {
                        dp[i][k] = true;
                    }
                    break;
                }
                // 若为普通，看看对不对就是了
                if (j > 0 && (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}