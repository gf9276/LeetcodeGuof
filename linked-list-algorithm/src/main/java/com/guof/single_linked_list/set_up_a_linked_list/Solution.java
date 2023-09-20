package com.guof.single_linked_list.set_up_a_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 * 写的不好，年纪大了，唉
 * 想我大二那会儿，真是悲哀
 *
 * @Author guof
 * @Create 2023/4/4 18:41
 * @Version 1.0
 */
class MyLinkedList {
    Point begin;
    Point end;

    public MyLinkedList() {
        begin = new Point(); // begin指定为空
        end = new Point(); // begin指定为空
        begin.next = end;
        end.prev = begin;
    }

    public int get(int index) {
        Point movingPoint = begin;
        for (int i = 0; i <= index; i++) {
            if (movingPoint.next != null) {
                movingPoint = movingPoint.next;
            } else {
                break;
            }
        }
        return movingPoint.equals(end) ? -1 : movingPoint.val;
    }

    public void addAtHead(int val) {
        Point tmp = new Point();
        tmp.val = val;
        tmp.next = begin.next;
        tmp.prev = begin;

        tmp.next.prev = tmp;
        begin.next = tmp;
    }

    public void addAtTail(int val) {
        Point tmp = new Point();
        tmp.val = val;
        tmp.prev = end.prev;
        tmp.next = end;

        tmp.prev.next = tmp;
        end.prev = tmp;
    }

    public void addAtIndex(int index, int val) {
        Point movingPoint = begin;
        for (int i = 0; i <= index; i++) {
            if (!movingPoint.next.equals(end)) {
                movingPoint = movingPoint.next;
            } else {
                if (i == index) {
                    addAtTail(val);
                }
                return;
            }
        }

        Point tmp = new Point();
        tmp.val = val;
        if (movingPoint != null) {
            movingPoint.prev.next = tmp;
            tmp.prev = movingPoint.prev;
            tmp.next = movingPoint;
            movingPoint.prev = tmp;
        }
    }

    public void deleteAtIndex(int index) {
        Point movingPoint = begin;
        for (int i = 0; i <= index; i++) {
            if (!movingPoint.next.equals(end)) {
                movingPoint = movingPoint.next;
            } else {
                return;
            }
        }

        if (movingPoint != null && !movingPoint.equals(end)) {
            movingPoint.next.prev = movingPoint.prev;
            movingPoint.prev.next = movingPoint.next;
        }
    }

    static class Point {
        int val;
        Point next;
        Point prev;

        public Point(Point point) {
            val = point.val;
            next = point.next;
            prev = point.prev;
        }

        public Point() {
        }
    }
}

