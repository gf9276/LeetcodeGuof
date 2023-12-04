package com.guof.front_middle_back_queue;


import java.util.Deque;
import java.util.LinkedList;

class FrontMiddleBackQueue {
    // 保持list1 = list2 或者 list2+1
    Deque<Integer> list1 = new LinkedList<>();
    Deque<Integer> list2 = new LinkedList<>();

    public FrontMiddleBackQueue() {

    }

    public void keepBalance() {
        // 保持左边的数量始终 等于 右边 或 比右边少一个
        int all_nbr = list1.size() + list2.size();
        while (list1.size() > all_nbr / 2) {
            list2.addFirst(list1.pollLast());
        }
        while (list1.size() < all_nbr / 2) {
            list1.addLast(list2.pollFirst());
        }
    }

    public void pushFront(int val) {
        list1.addFirst(val);
        keepBalance();
    }

    public void pushMiddle(int val) {
        list1.addLast(val);
        keepBalance();
    }

    public void pushBack(int val) {
        list2.addLast(val);
        keepBalance();
    }

    public int popFront() {
        int all_nbr = list1.size() + list2.size();
        if (all_nbr == 0) {
            return -1;
        }
        if (all_nbr == 1) {
            return list2.pollFirst();
        }
        int output = list1.pollFirst();

        keepBalance();

        return output;
    }

    public int popMiddle() {
        int all_nbr = list1.size() + list2.size();
        if (all_nbr == 0) {
            return -1;
        }
        int output;
        if (list1.size() == list2.size()) {
            output = list1.pollLast();
        } else {
            output = list2.pollFirst();
        }
        keepBalance();

        return output;
    }

    public int popBack() {
        int all_nbr = list1.size() + list2.size();
        if (all_nbr == 0) {
            return -1;
        }
        int output = list2.pollLast();

        keepBalance();
        return output;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */