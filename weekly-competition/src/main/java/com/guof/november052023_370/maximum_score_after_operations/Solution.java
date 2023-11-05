package com.guof.november052023_370.maximum_score_after_operations;


import java.util.*;

class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Set<Integer>[] arr = new HashSet[values.length]; // 记录与i相邻的点
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }

        long[][] arr2 = new long[values.length][2]; // 0表示该点的和，1表示该点最大的分数

        Queue<Integer> queue = new LinkedList<>(); // 层序遍历-->找爹行动
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].size() == 1 && i != 0) {
                // 说明是叶子节点
                queue.add(i);
                arr2[i][0] = values[i];
                arr2[i][1] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curIdx = queue.poll(); // 获取当前节点
                int parentIdx = new ArrayList<>(arr[curIdx]).get(0); // 获取他的爹节点

                // 继承儿子的家产
                arr2[parentIdx][0] += arr2[curIdx][0];
                arr2[parentIdx][1] += arr2[curIdx][1];

                arr[parentIdx].remove(curIdx); // 再把儿子扫地出门

                // 轮到你找爹了，0是所有的祖先，就不找了
                if (arr[parentIdx].size() == 1 && parentIdx != 0) {
                    // 扔掉自己
                    long score1 = arr2[parentIdx][1] + values[parentIdx];
                    // 不扔掉自己
                    long score2 = arr2[parentIdx][0];
                    arr2[parentIdx][1] = Math.max(score1, score2);
                    arr2[parentIdx][0] += values[parentIdx];
                    queue.add(parentIdx);
                }

            }
        }

        int parentIdx = 0;
        return Math.max(arr2[parentIdx][1] + values[parentIdx], arr2[parentIdx][0]);
    }
}

