package com.guof.december32023_374.minimum_added_coins;

import java.util.*;

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        // 模拟一下？
        // 推理到curTarget需要添加几个硬币
        Arrays.sort(coins); // 从小到大，方便
        int output = 0;

        Set<Integer> ansSet = new HashSet<>();

        int coinsIdx = 0;
        for (int i = 1; i <= target; i++) {
            while (coinsIdx < coins.length && coins[coinsIdx] <= i) {
                coinsIdx++;
                updateSet(ansSet, i, target);
            }
            if (!ansSet.contains(i)) {
                output++;
                updateSet(ansSet, i, target);
            }
            if (ansSet.size() == target) {
                return output;
            }
        }
        return output;
    }

    public void updateSet(Set<Integer> ansSet, int i, int target) {
        Integer[] tmp = ansSet.toArray(Integer[]::new);
        Arrays.sort(tmp);
        ansSet.add(i);
        for (int lastNbr : tmp) {
            if (lastNbr + i > target) {
                break;
            }
            ansSet.add(lastNbr + i);
        }
    }
}