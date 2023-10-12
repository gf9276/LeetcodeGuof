package com.guof.substring_xor_query;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int[][] output = new int[queries.length][2];
        Map<Integer, int[]> map = new HashMap<>();

        for (int l = 0; l < s.length(); l++) {
            if (s.charAt(l) == '0') {
                map.putIfAbsent(0, new int[]{l, l}); // 插过一次就不会插了
                continue;
            }
            for (int r = l, x = 0; r < Math.min(l + 30, s.length()); r++) {
                x = x << 1 | (s.charAt(r) & 1);
                map.putIfAbsent(x, new int[]{l, r}); // 先插入的肯定是短的，还用说？
            }
        }

        // 插完了直接查询就好了
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int curValue = query[0] ^ query[1]; // 接下来就是要找这样的一个字符串了，怎么找效率高？
            output[i] = Arrays.copyOf(map.getOrDefault(curValue, new int[]{-1, -1}), 2);
        }
        return output;
    }
}