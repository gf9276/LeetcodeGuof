package com.guof.october222023_368.min_number_of_legal_groups;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        // 统计每个数字的数量
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 我发现任何一个数字都可以用最小值去划分啊，获取最小的个数
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            min = Math.min(min, map.get(key));
        }

        int output = 0;
        int curNbr = min;
        boolean ok = true;
        while (true) {
            output = 0;
            ok = true;
            for (int key : map.keySet()) {
                int tmp = twoDig(map.get(key), curNbr + 1, curNbr);
                if (tmp == -1) {
                    ok = false;
                    break;
                } else {
                    output += tmp;
                }
            }
            if (ok) {
                return output;
            } else {
                curNbr -= 1;
            }
        }
    }

    public int twoDig(int num, int a, int b) {
        int n = 0;
        for (; ; ) {
            if (num == 0) {
                return n;
            }
            if (num < 0) {
                return -1;
            }
            if (num % a == 0) {
                return num / a + n;
            } else {
                num -= b;
                n++;
            }
        }
    }
}