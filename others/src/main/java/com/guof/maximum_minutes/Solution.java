package com.guof.maximum_minutes;


import java.util.*;

class Solution {
    int[][] peopleVisitedTime;
    int[][] fireVisitedTime;
    int m;
    int n;

    int inf = 0x3f3f3f3f;

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // 人
        peopleVisitedTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(peopleVisitedTime[i], inf); // 人类抵达每个草地的时间
        }
        Queue<Integer[]> peopleQueue = new LinkedList<>();
        peopleVisitedTime[0][0] = 0;
        peopleQueue.add(new Integer[]{0, 0});
        bfs(peopleQueue, peopleVisitedTime, grid);

        // 火
        fireVisitedTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(fireVisitedTime[i], inf); // 火焰抵达每个草地的时间
        }
        Queue<Integer[]> fireQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fireVisitedTime[i][j] = 0;
                    fireQueue.add(new Integer[]{i, j});
                }
            }
        }
        bfs(fireQueue, fireVisitedTime, grid);


        int maxTime = fireVisitedTime[m - 1][n - 1] - peopleVisitedTime[m - 1][n - 1];
        if (maxTime < 0 || peopleVisitedTime[m - 1][n - 1] == inf) {
            return -1;
        }
        if (fireVisitedTime[m - 1][n - 1] == inf) {
            return (int) 1e9;
        }
        if (peopleVisitedTime[m - 1][n - 2] != 0 && maxTime + peopleVisitedTime[m - 1][n - 2] < fireVisitedTime[m - 1][n - 2])
            return maxTime;
        if (peopleVisitedTime[m - 2][n - 1] != 0 && maxTime + peopleVisitedTime[m - 2][n - 1] < fireVisitedTime[m - 2][n - 1])
            return maxTime;
        return maxTime - 1;


    }

    public void bfs(Queue<Integer[]> queue, int[][] nbrGrid, int[][] grid) {
        int curNbr = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            curNbr++;
            for (int i = 0; i < size; i++) {
                int curX = queue.peek()[0];
                int curY = queue.poll()[1];
                if (inScope(curX - 1, curY) && nbrGrid[curX - 1][curY] > curNbr && grid[curX - 1][curY] == 0) {
                    nbrGrid[curX - 1][curY] = curNbr;
                    queue.add(new Integer[]{curX - 1, curY});
                }
                if (inScope(curX + 1, curY) && nbrGrid[curX + 1][curY] > curNbr && grid[curX + 1][curY] == 0) {
                    nbrGrid[curX + 1][curY] = curNbr;
                    queue.add(new Integer[]{curX + 1, curY});
                }
                if (inScope(curX, curY - 1) && nbrGrid[curX][curY - 1] > curNbr && grid[curX][curY - 1] == 0) {
                    nbrGrid[curX][curY - 1] = curNbr;
                    queue.add(new Integer[]{curX, curY - 1});
                }
                if (inScope(curX, curY + 1) && nbrGrid[curX][curY + 1] > curNbr && grid[curX][curY + 1] == 0) {
                    nbrGrid[curX][curY + 1] = curNbr;
                    queue.add(new Integer[]{curX, curY + 1});
                }
            }
        }
    }


    public boolean inScope(int curX, int curY) {
        return (curX >= 0 && curX < m && curY >= 0 && curY < n);
    }

}