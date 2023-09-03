package com.feng.queue_fifo_data_structure.moving_average_in_data_flow;


import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    Queue<Integer> queue;
    int size;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        if (queue.size() > size) queue.poll();

        int queueSize = queue.size();


        double sum = 0;


        for (int i = 0; i < queueSize; i++) {
            Integer tmp = queue.poll();
            if (tmp != null) {
                sum += tmp;
            }
            queue.add(tmp);
        }

        return sum / queue.size();
    }
}
