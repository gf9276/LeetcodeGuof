package com.guof.average_salary_after_removing_minimum_and_maximum_wages;


class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int j : salary) {
            sum += j;
            max = Math.max(max, j);
            min = Math.min(min, j);
        }

        return (double) (sum - max - min) / (salary.length - 2);
    }
}