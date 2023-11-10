package com.guof.count_arrangement;


class Solution {
    int n;

    public int countArrangement(int n) {
        this.n = n;
        int mask = (1 << n) - 1; // 0表示用过了，1表示没用过
        return dfs(mask, 0);
    }

    public int dfs(int mask, int curIdx) {
        if (curIdx == n) {
            // 恭喜抵达终点，完成一种目标
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 0) {
                // 这个点用过了
                continue;
            }
            if ((i + 1) % (curIdx + 1) != 0 && (curIdx + 1) % (i + 1) != 0) {
                continue; // 不符合条件
            }
            mask &= ~(1 << i);
            sum += dfs(mask, curIdx + 1);
            mask |= (1 << i);
        }
        return sum;
    }
}