package com.guof.summary.using_queues_to_implement_stacks;


import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue = new LinkedList<>(); // 正队列

    public MyStack() {
        queue.clear();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (empty()) return -1;

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }

        return queue.poll();
    }

    public int top() {
        if (empty()) return -1;

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }

        queue.add(queue.peek());

        return queue.poll();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
