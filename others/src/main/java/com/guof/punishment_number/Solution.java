package com.guof.punishment_number;


class Solution {
    static int[] dp = new int[1010];

    static {
        for (int i = 1; i <= 1000; i++) {
            dp[i] = dp[i - 1];
            if (punish(i, String.valueOf(i * i), 0)) {
                dp[i] += i * i;
            }
        }
    }

    public int punishmentNumber(int n) {
        return dp[n];
    }

    static boolean punish(int oriValue, String curValueStr, int sum) {
        if (sum > oriValue) {
            return false;
        }
        if (sum == oriValue && curValueStr.isEmpty()) {
            return true;
        }

        boolean result = false;
        for (int i = 1; i <= curValueStr.length(); i++) {
            int tmp = Integer.parseInt(curValueStr.substring(0, i));
            sum += tmp;

            result |= punish(oriValue, curValueStr.substring(i), sum);

            sum -= tmp;
        }
        return result;
    }
}