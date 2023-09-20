package com.guof.summary.matrix01;


import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        int[][] output = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    output[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.add(new Integer[]{i, j});
                    set.add(Arrays.toString(new Integer[]{i, j}));
                }
            }
        }

        int nbr = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] coord = queue.poll();
                assert coord != null;
                int new_sr = coord[0];
                int new_sc = coord[1];
                if (!safe(mat, new_sr, new_sc)) continue;
                if (mat[new_sr][new_sc] == 1) {
                    output[new_sr][new_sc] = Math.min(output[new_sr][new_sc], nbr);
                }
                if (!set.contains(Arrays.toString(new Integer[]{new_sr - 1, new_sc}))) {
                    set.add(Arrays.toString(new Integer[]{new_sr - 1, new_sc}));
                    queue.add(new Integer[]{new_sr - 1, new_sc});
                }
                if (!set.contains(Arrays.toString(new Integer[]{new_sr + 1, new_sc}))) {
                    set.add(Arrays.toString(new Integer[]{new_sr + 1, new_sc}));
                    queue.add(new Integer[]{new_sr + 1, new_sc});
                }
                if (!set.contains(Arrays.toString(new Integer[]{new_sr, new_sc + 1}))) {
                    set.add(Arrays.toString(new Integer[]{new_sr, new_sc + 1}));
                    queue.add(new Integer[]{new_sr, new_sc + 1});
                }
                if (!set.contains(Arrays.toString(new Integer[]{new_sr, new_sc - 1}))) {
                    set.add(Arrays.toString(new Integer[]{new_sr, new_sc - 1}));
                    queue.add(new Integer[]{new_sr, new_sc - 1});
                }

            }
            nbr++;
        }

        return output;

    }

    public boolean safe(int[][] mat, int sr, int sc) {
        if (sr < 0) return false;
        if (sc < 0) return false;
        if (sr > mat.length - 1) return false;
        if (sc > mat[0].length - 1) return false;

        return true;
    }
}