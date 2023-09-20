package com.guof.other.hamming_distance;

/**
 * ClassName: Solution
 * Package: com.feng.other.hamming_distance
 * Description:
 *
 * @Author guof
 * @Create 2023/4/2 22:50
 * @Version 1.0
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >>> i) & 1) != ((y >>> i) & 1)) {
                dist++;
            }
        }
        return dist;
    }
}