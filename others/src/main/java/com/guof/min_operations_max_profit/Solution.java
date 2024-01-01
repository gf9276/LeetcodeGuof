package com.guof.min_operations_max_profit;


class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // 转动四次一个循环，所以最多转动  n+4 次
        int maxPro = 0;
        int curPro = 0;
        int output = -1;
        int curPerson = 0; // 现在没人
        for (int i = 0; i < customers.length || curPerson > 0; i++) {
            if (i < customers.length) {
                curPerson += customers[i]; // 来人了
            }
            curPro += Math.min(curPerson, 4) * boardingCost; // 先收钱
            curPerson = Math.max(curPerson - 4, 0);
            curPro -= runningCost; // 再转动一次

            if (curPro > maxPro) {
                maxPro = curPro;
                output = i + 1;
            }
        }

        return output;
    }
}