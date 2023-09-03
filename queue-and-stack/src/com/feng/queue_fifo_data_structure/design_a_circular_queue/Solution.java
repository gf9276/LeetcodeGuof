package com.feng.queue_fifo_data_structure.design_a_circular_queue;


class MyCircularQueue {
    int[] array;
    int head;
    int end;


    public MyCircularQueue(int k) {
        array = new int[k + 1];
        head = 0; // 指向第一个
        end = 0; // 指向最后一个的下一个
    }

    private int circulate_ins(int value) {
        value = value + 1;
        return value == array.length ? 0 : value;
    }

    private int circulate_des(int value) {
        value = value - 1;
        return value == -1 ? array.length - 1 : value;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        array[end] = value;

        end = circulate_ins(end);

        return true;

    }


    public boolean deQueue() {
        if (isEmpty()) return false;

        head = circulate_ins(head);

        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;

        return array[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;

        return array[circulate_des(end)];
    }

    public boolean isEmpty() {
        return head == end;
    }

    public boolean isFull() {
        return head == circulate_ins(end);
    }
}
