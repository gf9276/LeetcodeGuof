package com.guof.cmp_2024_01_07_379.area_of_max_diagonal;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = 0;
        int output = 0;
        for (int[] dimension : dimensions) {
            if (dimension[0] * dimension[0] + dimension[1] * dimension[1] > max) {
                output = dimension[0] * dimension[1];
                max = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            } else if (dimension[0] * dimension[0] + dimension[1] * dimension[1] == max) {
                output = Math.max(output, dimension[0] * dimension[1]);
            }
        }
        return output;
    }
}