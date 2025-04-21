package com.guof.meituan.five;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long mod = 1000000007;
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 朋友数量
        int m = in.nextInt(); // 暗恋关系数量

        int[][] relations = new int[m][2]; // 0 暗恋 1

        for (int i = 0; i < m; i++) {
            int u = in.nextInt(); // u暗恋v
            int v = in.nextInt();
            relations[i][0] = u;
            relations[i][1] = v;
        }

    }
}