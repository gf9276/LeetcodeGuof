package com.guof.first_complete_index;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // mat变成时间就好了，我真是太聪明了
        // 查找怕不是要用二分啊
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int[] rowMax = new int[mat.length];
        int[] colMax = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                rowMax[i] = Math.max(rowMax[i], map.get(mat[i][j]));
                colMax[j] = Math.max(colMax[j], map.get(mat[i][j]));
            }
        }

        return Math.min(Arrays.stream(rowMax).min().getAsInt(), Arrays.stream(colMax).min().getAsInt());
    }
}