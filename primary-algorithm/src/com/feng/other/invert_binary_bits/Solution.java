package com.feng.other.invert_binary_bits;

/**
 * ClassName: Solution
 * Package: com.feng.invert_binary_bits
 * Description:
 *
 * @Author guof
 * @Create 2023/4/3 21:55
 * @Version 1.0
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int out = 0;

        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                out = (out << 1) + 1; // 补0

            } else {
                out = (out << 1);
            }
        }
        return out;
    }
}