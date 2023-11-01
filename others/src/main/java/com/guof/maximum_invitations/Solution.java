package com.guof.maximum_invitations;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maximumInvitations(int[] favorite) {
        int[] in = new int[favorite.length]; // 统计每个人的入度情况
        int[] maxLen = new int[favorite.length]; // 统计每个人尾巴有多长
        for (int j : favorite) {
            in[j]++;
        }
        Queue<Integer> queue = new LinkedList<>(); // 队列用来拓扑排序
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                // 入度为0，排序肯定在最前面
                queue.add(i);
            }
        }

        // 用拓扑排序找环，排序完之后，剩下的都是环
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            int nextNode = favorite[curNode];
            maxLen[nextNode] = Math.max(maxLen[nextNode], maxLen[curNode] + 1); // 更新尾巴的长度
            if (--in[nextNode] == 0) {
                queue.add(nextNode); // 没有进入的了，加入队列
            }
        }

        // 现在in[i]不为0只有成环这一种情况了
        int output1 = 0; // 记录大于2的情况
        int output2 = 0; // 记录环为2的情况

        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                // 不是环
                continue;
            }
            int j = favorite[i]; // 现在你是下一个了
            int cnt = 1;
            while (i != j) {
                in[j] = 0; // 防止重复计算一个环
                cnt++;
                j = favorite[j];
            }

            if (cnt == 2) {
                output2 += 2 + maxLen[i] + maxLen[favorite[i]]; // 环+拖尾长度
            } else {
                output1 = Math.max(output1, cnt); // 环的长度
            }
        }
        return Math.max(output1, output2);
    }
}