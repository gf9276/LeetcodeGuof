package com.guof.meituan.two;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // n个

        int[] arr = new int[n]; // 存放原始数组

        int curMax = 0;

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt(); // 逐个读取
            curMax = Math.max(arr[i], curMax);
        }

        for (int i = 0; i < n; i++) {
            arr[i] *= 2;
            curMax = Math.max(arr[i], curMax);
            output[i] = curMax;
        }

        for (int j : output) {
            System.out.print(j);
            System.out.print(" ");
        }

    }
}