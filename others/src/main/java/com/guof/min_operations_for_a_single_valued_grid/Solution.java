package com.guof.min_operations_for_a_single_valued_grid;


class Solution {
    public int minOperations(int[][] grid, int x) {
        // 判断是否可行，看任意两个数之间的差值是否为x的倍数
        // 递推一下，只看其中一个数和其他数字的差值是否为x的倍数就行，毕竟变换都可以以这个数字为中间节点
        // 那么什么是最小操作数？选择最接近平均数的点，效果理论是最好的，那么，我就明白了
        int m = grid.length;
        int n = grid[0].length;


        // 第一轮，找到最小值，并判断是否可变换
        int base = grid[0][0];
        int min = Integer.MAX_VALUE;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                min = Math.min(min, anInt);
                if ((anInt - base) % x != 0) {
                    return -1;
                }
            }
        }

        // 第二轮，修改grid，并统计sum
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (grid[i][j] - min) / x;
                sum += grid[i][j];
            }
        }

        // 第三轮，统计变化次数
        int avg = sum / (m * n);
        int output = getSum(grid, Integer.MAX_VALUE, avg);
        int i = 1;
        int tmp = getSum(grid, output, avg + i);
        while (output > tmp) {
            output = tmp;
            i++;
            tmp = getSum(grid, output, avg + i);
        }
        i = -1;
        tmp = getSum(grid, output, avg + i);
        while (output > tmp) {
            output = tmp;
            i--;
            tmp = getSum(grid, output, avg + i);
        }
        return output;
    }

    public int getSum(int[][] grid, int min, int i) {
        int curSum = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                curSum += Math.abs(anInt - i);
                if (curSum > min) {
                    return curSum;
                }
            }
        }
        return curSum;
    }
}