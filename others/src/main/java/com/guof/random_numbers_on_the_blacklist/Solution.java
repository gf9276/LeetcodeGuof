package com.guof.random_numbers_on_the_blacklist;


import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    int n; // 总数
    int m; // 黑名单数
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>(); // 映射用的，将0~n-m中的黑名单变成白名单

    public Solution(int n, int[] blacklist) {
        this.n = n;
        this.m = blacklist.length;

        Arrays.sort(blacklist);

        // left表示比大于等于 n-m 的第一个下角标
        int left = 0;
        int right = blacklist.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (blacklist[mid] >= n - m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // n-m之前的都得映射到n-m之后
        // 如果left==blacklist.length, 说明不存在大于等于n-m的索引

        boolean[] white = new boolean[m]; // 记录 [n-m, n-1] 这个范围里的白名单
        Arrays.fill(white, true); // 默认都是白名单
        for (int i = left; i < m; i++) {
            white[blacklist[i] - (n - m)] = false; // 记录黑名单
        }
        int curIdx = n - m;
        for (int i = 0; i < left; i++) {
            while (!white[curIdx-(n-m)]) {
                curIdx++;
            }
            map.put(blacklist[i], curIdx++);
        }
    }

    public int pick() {
        int val = random.nextInt(n - m);
        return map.getOrDefault(val, val); // 默认返回自己，如果没有映射关系的话
    }
}
