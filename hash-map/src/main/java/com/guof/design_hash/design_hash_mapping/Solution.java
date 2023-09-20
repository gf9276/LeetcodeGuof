package com.guof.design_hash.design_hash_mapping;

import java.util.ArrayList;

class MyHashMap {
    // 拉链法
    int buckets = 1009;
    ArrayList<Integer[]>[] arrays = new ArrayList[buckets];
    int[] all_value = new int[buckets];

    public MyHashMap() {
        for (int i = 0; i <buckets; i++) {
            arrays[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int true_key = key % buckets;
        for (Integer[] items : arrays[true_key]) {
            if (items[0] == key) {
                items[1] = value;
                return;
            }
        }
        arrays[true_key].add(new Integer[]{key, value});

    }

    public int get(int key) {
        int true_key = key % buckets;
        for (Integer[] items : arrays[true_key]) {
            if (items[0] == key) {
                return items[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int true_key = key % buckets;
        for (int i = 0; i < arrays[true_key].size(); i++) {
            Integer[] items = arrays[true_key].get(i);
            if (items[0] == key) {
                arrays[true_key].remove(i);
                return;
            }
        }

    }
}
