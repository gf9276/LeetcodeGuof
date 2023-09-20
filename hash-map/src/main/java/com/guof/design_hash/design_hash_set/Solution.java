package com.guof.design_hash.design_hash_set;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    List<Integer> keyList;

    public MyHashSet() {
        keyList = new ArrayList<>();

    }

    public void add(int key) {
        if (contains(key)) return;
        keyList.add(key);

    }

    public void remove(int key) {
        for (int i = 0; i < keyList.size(); i++) {
            if (keyList.get(i) == key) {
                keyList.remove(i);
                return;
            }
        }
    }

    public boolean contains(int key) {
        for (Integer integer : keyList) {
            if (integer == key) {
                return true;
            }
        }
        return false;
    }
}