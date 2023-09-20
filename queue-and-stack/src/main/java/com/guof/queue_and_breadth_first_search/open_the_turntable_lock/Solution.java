package com.guof.queue_and_breadth_first_search.open_the_turntable_lock;


import java.util.*;

class Solution {


    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends)); // Set方便判断是否contain
        Set<String> exitSet = new HashSet<>();

        String startStr = "0000"; // 根节点

        if (deadendsSet.contains(startStr)) return -1;

        Queue<String> queue = new LinkedList<>(); // 创建队列，准备bfs

        // 八叉树，怎么办呢
        // 八个树枝，每个位置上下动一下
        // 还需要知道每一个的层数

        queue.add(startStr);

        int now_num = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 每一层的节点数
            for (int i = 0; i < size; i++) {
                String nowStr = queue.poll();
                if (target.equals(nowStr)) return now_num;
                for (int j = 0; j < 2 * nowStr.length(); j++) {
                    char[] c = nowStr.toCharArray();
                    boolean addOrSub = (j % 2 == 0); // true add, false sub
                    c[j / 2] = (char) (addOrSub ? c[j / 2] + 1 : c[j / 2] - 1);
                    c[j / 2] = c[j / 2] == '9' + 1 ? '0' : c[j / 2];
                    c[j / 2] = c[j / 2] == '0' - 1 ? '9' : c[j / 2];

                    String tmp = String.valueOf(c);

                    if (deadendsSet.contains(tmp)) continue;
                    if (exitSet.contains((tmp))) continue;

                    exitSet.add(tmp);
                    queue.add(tmp);
                }
            }
            now_num++;
        }
        return -1;
    }
}