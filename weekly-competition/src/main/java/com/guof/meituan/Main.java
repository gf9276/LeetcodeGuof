package com.guof.meituan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt(); //  总分

        int x = in.nextInt(); // 写作比听力搞了x分

        int y = in.nextInt(); // 写作比阅读低了y分

        int a = (k + x - y) / 3;
        int b = a - x;
        int c = a + y;

        // 输出。。。。
    }
}