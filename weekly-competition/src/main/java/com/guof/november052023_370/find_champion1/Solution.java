package com.guof.november052023_370.find_champion1;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        List<Integer>[] arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // i比j强
                if (grid[i][j] == 1) {
                    arr[j].add(i);
                }
            }
        }

        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].isEmpty()) {
                champion = i;
            }
        }
        return champion;
    }
}