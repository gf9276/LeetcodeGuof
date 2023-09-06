package com.feng.practical_application_design_key.multiplication_of_sparse_matrices;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        Map<Integer[], Integer> map1 = new HashMap<>();
        Map<Integer[], Integer> map2 = new HashMap<>();

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0) {
                    Integer[] coord = new Integer[]{i, j};
                    map1.put(coord, mat1[i][j]);
                }
            }
        }

        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                if (mat2[i][j] != 0) {
                    Integer[] coord = new Integer[]{i, j};
                    map2.put(coord, mat2[i][j]);
                }
            }
        }
        if (map1.isEmpty() || map2.isEmpty()) return new int[mat1.length][mat2[0].length];

        int[][] output = new int[mat1.length][mat2[0].length];


        for (Integer[] coord1 : map1.keySet()) {
            for (Integer[] coord2 : map2.keySet()) {
                if (Objects.equals(coord1[1], coord2[0])) {
                    output[coord1[0]][coord2[1]] += map1.get(coord1) * map2.get(coord2);
                }

            }
        }

        return output;
    }
}