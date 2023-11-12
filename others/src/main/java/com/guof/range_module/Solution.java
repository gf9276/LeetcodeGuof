package com.guof.range_module;


import java.util.ArrayList;
import java.util.List;

class RangeModule {
    List<Integer[]> rangeList = new ArrayList<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        List<Integer[]> newRangeList = new ArrayList<>();
        boolean insert = false;

        for (int i = 0; i < rangeList.size(); i++) {
            Integer[] integers = rangeList.get(i);
            int start = integers[0];
            int end = integers[1];

            if (end < left) {
                newRangeList.add(new Integer[]{start, end});
            } else if (right < start) {
                if (!insert) {
                    insert = true;
                    newRangeList.add(new Integer[]{left, right});
                }
                newRangeList.add(new Integer[]{start, end});
            } else {
                // 交叉了
                left = Math.min(left, start);
                right = Math.max(right, end);
            }
        }
        if (!insert) {
            insert = true;
            newRangeList.add(new Integer[]{left, right});
        }
        rangeList = newRangeList;
    }

    public boolean queryRange(int left, int right) {
        for (Integer[] integers : rangeList) {
            int start = integers[0];
            int end = integers[1];
            if (start <= left && end >= right) {
                return true;
            } else if (right <= end) {
                // 居然没有被回收，那完蛋了
                break;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        List<Integer[]> newRangeList = new ArrayList<>();

        for (Integer[] integers : rangeList) {
            int start = integers[0];
            int end = integers[1];
            if (end <= left || start >= right) {
                // 不在删除范围之内
                newRangeList.add(integers);
            } else {
                // 反之就是  end > left 且 start < right
                if (start < left) {
                    // 头都给你删了
                    newRangeList.add(new Integer[]{start, left});
                }
                if (end > right) {
                    newRangeList.add(new Integer[]{right, end});
                }
            }
        }

        rangeList = newRangeList;
    }
}
