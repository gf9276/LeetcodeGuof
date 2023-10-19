package com.guof.lfu_cache;


import java.util.*;

class LFUCache {
    // 咱们都知道
    PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b) -> {
        if (Objects.equals(a[1], b[1])) {
            return a[2] - b[2]; // 小的在前面
        }
        return a[1] - b[1];
    }); // 最小堆 0 是 key，1 是使用次数，2最近一次访问的时间
    Map<Integer, Integer> map1 = new HashMap<>(); // 记录值
    Map<Integer, Integer> map2 = new HashMap<>(); // 记录次数
    int capacity;
    int operationCount = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        operationCount++;
        if (!map1.containsKey(key)) {
            // 不存在直接滚
            return -1;
        }

        map2.put(key, map2.get(key) + 1); // 多用了一次
        heap.add(new Integer[]{key, map2.get(key), operationCount}); // 记录这多用的一次

        return map1.get(key);
    }

    public void put(int key, int value) {
        operationCount++;
        if (!map1.containsKey(key) && map1.size() >= capacity) {
            // 来新的了，但是没容量，就得先删除了，次数对不上的都是残留垃圾
            while (!Objects.equals(heap.peek()[1], map2.get(heap.peek()[0]))) {
                heap.poll();
            }
            map1.remove(heap.peek()[0]);
            map2.remove(heap.peek()[0]);
        }

        map1.put(key, value);
        map2.put(key, map2.getOrDefault(key, 0) + 1);
        heap.add(new Integer[]{key, map2.get(key), operationCount}); // 并记录
    }
}