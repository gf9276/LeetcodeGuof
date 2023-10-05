package com.guof.design_issues.median_of_data_flow;

import java.util.PriorityQueue;

class MedianFinder {
    // 挺有意思的，看到这题目的第一眼，我就想用优先队列，搞两个就好了
    PriorityQueue<Integer> priorityQueueLeft;
    PriorityQueue<Integer> priorityQueueRight;

    Integer curValue;

    public MedianFinder() {
        priorityQueueLeft = new PriorityQueue<>((a, b) -> b - a); // 左边用最大堆
        priorityQueueRight = new PriorityQueue<>((a, b) -> a - b); // 右边用最小堆
        curValue = null;
    }

    public void addNum(int num) {
        if (curValue == null) {
            curValue = num;
        } else if (num <= curValue) {
            if (priorityQueueLeft.size() < priorityQueueRight.size()) {
                priorityQueueLeft.add(num);
            } else {
                priorityQueueRight.add(curValue);
                priorityQueueLeft.add(num);
                curValue = priorityQueueLeft.poll();
            }
        } else {
            if (priorityQueueRight.size() == priorityQueueLeft.size()) {
                priorityQueueRight.add(num);
            } else {
                priorityQueueLeft.add(curValue);
                priorityQueueRight.add(num);
                curValue = priorityQueueRight.poll();
            }
        }
    }

    public double findMedian() {
        if (priorityQueueLeft.size() == priorityQueueRight.size()) {
            return curValue;
        } else {
            return 0.5 * (curValue + priorityQueueRight.peek());
        }
    }
}