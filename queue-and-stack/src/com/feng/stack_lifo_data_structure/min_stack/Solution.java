package com.feng.stack_lifo_data_structure.min_stack;


import java.util.ArrayList;
import java.util.List;

class MinStack {

    List<Integer> list;
    Integer min = Integer.MAX_VALUE;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        min = Math.min(min, val);
    }

    public void pop() {
        int size = list.size();
        int val = list.get(size - 1);
        list.remove(size - 1);
        if (val == min) {
            min = Integer.MAX_VALUE;
            for (Integer i : list) {
                min = Math.min(min, i);
            }
        }
    }

    public int top() {
        int size = list.size();
        return list.get(size - 1);
    }

    public int getMin() {
        return min;
    }
}

