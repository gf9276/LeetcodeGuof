package com.guof.exam_room;


import java.util.*;

class ExamRoom {

    PriorityQueue<int[]> heap;
    Map<Integer, Integer> left;
    Map<Integer, Integer> right;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        heap = new PriorityQueue<>((a, b) -> {
            Integer[] seatAndDistA = getDistAndSeat(a);
            Integer[] seatAndDistB = getDistAndSeat(b);
            if (Objects.equals(seatAndDistA[1], seatAndDistB[1])) {
                return seatAndDistA[0] - seatAndDistB[0];
            }
            return seatAndDistB[1] - seatAndDistA[1];
        }); // 最大堆
        heap.add(new int[]{-1, n});

        left = new HashMap<>();
        left.put(n, -1);
        left.put(-1, -1);
        right = new HashMap<>();
        right.put(-1, n);
        right.put(n, n);
    }

    public int seat() {
        int[] curSpace;
        Integer[] seatAndDist;
        int seat;

        do {
            curSpace = heap.poll();
            seatAndDist = getDistAndSeat(curSpace);
            seat = seatAndDist[0];
        } while (!(right.containsKey(curSpace[0]) && left.containsKey(curSpace[0]) && right.containsKey(curSpace[1]) && left.containsKey(curSpace[1])));

        if (seat - curSpace[0] >= 2) {
            heap.add(new int[]{curSpace[0], seat});
        }
        if (curSpace[1] - seat >= 2) {
            heap.add(new int[]{seat, curSpace[1]});
        }
        left.put(seat, curSpace[0]);
        right.put(curSpace[0], seat);
        right.put(seat, curSpace[1]);
        left.put(curSpace[1], seat);
        return seat;
    }

    public void leave(int p) {
//        heap.remove(new int[]{left.get(p), p}); // 删不掉的
//        heap.remove(new int[]{p, right.get(p)});
        heap.add(new int[]{left.get(p), right.get(p)});
        right.put(left.get(p), right.get(p));
        left.put(right.get(p), left.get(p));
        left.remove(p);
        right.remove(p);
    }

    public Integer[] getDistAndSeat(int[] curSpace) {
        int seat;
        int dist;
        if (curSpace[0] == -1) {
            seat = 0;
            dist = curSpace[1] - seat;
        } else if (curSpace[1] == n) {
            seat = n - 1;
            dist = seat - curSpace[0];
        } else {
            seat = (curSpace[1] + curSpace[0]) / 2;
            dist = Math.min(curSpace[1] - seat, seat - curSpace[0]);
        }
        return new Integer[]{seat, dist};
    }
}
