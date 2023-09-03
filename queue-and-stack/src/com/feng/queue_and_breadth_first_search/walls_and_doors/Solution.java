package com.feng.queue_and_breadth_first_search.walls_and_doors;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        // 广度优先搜索 很简单

        Queue<Integer[]> queue = new LinkedList<>();

        // 放入门的坐标
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new Integer[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            Integer[] coord = queue.poll();

            int tmp_i;
            int tmp_j;

            if (coord[0] + 1 < rooms.length) {
                tmp_i = coord[0] + 1;
                tmp_j = coord[1];
                diffuse(rooms, tmp_i, tmp_j, coord, queue);
            }
            if (coord[0] - 1 > -1) {
                tmp_i = coord[0] - 1;
                tmp_j = coord[1];
                diffuse(rooms, tmp_i, tmp_j, coord, queue);
            }
            if (coord[1] + 1 < rooms[0].length) {
                tmp_i = coord[0];
                tmp_j = coord[1] + 1;
                diffuse(rooms, tmp_i, tmp_j, coord, queue);
            }
            if (coord[1] - 1 > -1) {
                tmp_i = coord[0];
                tmp_j = coord[1] - 1;
                diffuse(rooms, tmp_i, tmp_j, coord, queue);
            }

        }
    }

    public void diffuse(int[][] rooms, int tmp_i, int tmp_j, Integer[] coord, Queue<Integer[]> queue) {
        if (rooms[tmp_i][tmp_j] != -1) {
            if (rooms[tmp_i][tmp_j] > rooms[coord[0]][coord[1]] + 1) {
                rooms[tmp_i][tmp_j] = rooms[coord[0]][coord[1]] + 1;
                queue.add(new Integer[]{tmp_i, tmp_j});
            }
        }
    }
}