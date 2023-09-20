package com.guof.summary_and_discussion.constant_time_insertion_deletion_and_retrieval_of_random_elements;

import java.util.*;

class RandomizedSet {
    Set<Integer> set = new HashSet<>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        int size = set.size();
        int randomIdx = random.nextInt(size);
        List<Integer> list = new ArrayList<>(set);

        return list.get(randomIdx);

    }
}