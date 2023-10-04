package com.guof.mathematics.max_number_of_points_on_a_straight_line;

class Solution {
    public int maxPoints(int[][] points) {
        int output = 1;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int curCnt = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int y3 = points[k][1];
                    int x3 = points[k][0];
                    int y2 = points[j][1];
                    int x2 = points[j][0];
                    int y1 = points[i][1];
                    int x1 = points[i][0];

                    if ((y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1)) {
                        curCnt++;
                    }
                }
                output = Math.max(curCnt, output);
            }
        }
        return output;
    }
}