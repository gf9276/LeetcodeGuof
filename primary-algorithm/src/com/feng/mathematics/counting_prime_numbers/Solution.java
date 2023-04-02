package com.feng.mathematics.counting_prime_numbers;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        // 初始化全部为质数
        boolean[] isPrimeArray = new boolean[n];
        Arrays.fill(isPrimeArray, true);
        // 从2开始，将所有质数的x倍全部标记为合数,一直标记到根号n
        for (int i = 2; i * i < n; i++) {
            if (isPrimeArray[i]) {
                int x = i;
                while (i * x < n) {
                    isPrimeArray[i * x] = false;
                    x++;
                }
            }
        }
        // 从 2 开始计数
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeArray[i]) {
                result++;
            }
        }
        return result;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
