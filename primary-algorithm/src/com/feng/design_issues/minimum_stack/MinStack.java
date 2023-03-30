package com.feng.design_issues.minimum_stack;

/**
 * ClassName: MinStack
 * Package: com.feng.design_issues.minimum_stack
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:25
 * @Version 1.0
 */
class MinStack {
    private ListNode head;

    public MinStack() {
    }

    public void push(int val) {
        // 入栈，先判断是否为空
        if (head == null)
            head = new ListNode(val, val, null);
        else
            head = new ListNode(val, Math.min(val, head.min), head);
    }

    public void pop() {
        // 判断是否为空
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class ListNode {
    public int val;
    public int min; //最小值
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
