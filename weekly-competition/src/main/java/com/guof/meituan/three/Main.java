package com.guof.meituan.three;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long mod = 1000000007;
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next(); // s的长度是n

        int[] charCnt = new int[26];

        for (char c : s.toCharArray()) {
            charCnt[c - 'a']++; // 统计频率
        }

        Arrays.sort(charCnt);

        // 根据乘法原理，两两计算就好了

        long ans = 0; // 写成Long没事的。方便点
        for (int i = 0; i < charCnt.length - 1; i++) {
            if (charCnt[i] == 0) {
                continue;
            }
            long[] poss1 = new long[charCnt[i] + 1]; // 一共有n种可能
            poss1[0] = 1;
            // 第 i 个字母 和 后面的字母一一配队
            for (int j = 1; j < poss1.length; j++) {
                poss1[j] = poss1[j - 1] * (charCnt[i] - j + 1) / j;
            }
            for (int j = i + 1; j < charCnt.length; j++) {
                long[] poss2 = new long[charCnt[i] + 1]; // 一共有n种可能
                poss2[0] = 1;
                for (int k = 1; k < poss2.length; k++) {
                    poss2[k] = poss2[k - 1] * (charCnt[j] - k + 1) / k;
                }
                for (int k = 1; k < charCnt[i] + 1; k++) {
                    // 什么都不取，不算
                    ans = (ans + (poss1[k] * poss2[k])) % mod;
                }
            }
        }
        System.out.print(ans);
    }
}