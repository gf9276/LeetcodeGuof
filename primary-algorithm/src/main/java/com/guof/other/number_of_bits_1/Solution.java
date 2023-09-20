package com.guof.other.number_of_bits_1;

/**
 * ClassName: Solution
 * Package: com.feng.other.number_of_bits_1
 * Description:
 *
 * @Author guof
 * @Create 2023/4/2 22:46
 * @Version 1.0
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) { // >>>高位补0，>>高位补1
                cnt++;
            }
        }
        return cnt;
    }
}