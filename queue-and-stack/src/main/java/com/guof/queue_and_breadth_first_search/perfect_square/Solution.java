package com.guof.queue_and_breadth_first_search.perfect_square;


import java.util.*;

class Solution {
    public int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> exitSet = new LinkedHashSet<>();

        queue.add(n);

        int cur_num = 0;
        int max_sqrt;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int out = queue.poll();
                if (out == 0) return cur_num;
                max_sqrt = (int) Math.sqrt(out);
                for (int j = 1; j <= max_sqrt; j++) {
                    Integer now_value = out - j * j;

                    if (now_value < 0) continue;

                    if (exitSet.contains(now_value)) continue;

                    exitSet.add(now_value);
                    queue.add(now_value);

                }


            }
            cur_num++;
        }

        return -1;
    }
}