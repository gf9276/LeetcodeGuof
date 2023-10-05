package com.guof.design_issues.lru_caching_mechanism;

import java.util.*;

class LRUCache {

    int curCapacity; // 记录当前的容量
    int capacity; // 记录总的容量
    Map<Integer, Integer> map; // 记录 key map 队

    public LRUCache(int capacity) {
        curCapacity = 0;
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 放到最后面去
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 已经有了，改变value
            map.remove(key);
            map.put(key, value);
        } else {
            // 如果没有，判断容量
            if (curCapacity < capacity) {
                // 如果还有容量，当前容量+1
                curCapacity++;
            } else {
                // 如果没有容量了，第一个只能让他滚了
                Integer firstKey = map.keySet().toArray(new Integer[0])[0];
                map.remove(firstKey);
            }
            map.put(key, value);
        }
    }
}