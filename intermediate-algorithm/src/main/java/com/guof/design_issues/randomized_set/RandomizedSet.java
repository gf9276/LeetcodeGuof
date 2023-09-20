package com.guof.design_issues.randomized_set;

import java.util.HashMap;
import java.util.Random;

/**
 * ClassName: RandomizedSet
 * Package: com.feng.design_issues.randomized_set
 * Description:
 *
 * @Author guof
 * @Create 2023/4/30 21:52
 * @Version 1.0
 */
class RandomizedSet {

    HashMap<Integer, Integer> valueSet = new HashMap<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (valueSet.containsKey(val)) {
            return false;
        }

        valueSet.put(val, val);
        return true;
    }

    public boolean remove(int val) {
        if (valueSet.containsKey(val)) {
            valueSet.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Integer[] keys = valueSet.keySet().toArray(new Integer[0]);
        Random r = new Random();
        return valueSet.get(keys[r.nextInt(keys.length)]);
    }
}
