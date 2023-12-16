package com.guof.count_intervals;


import java.util.ArrayList;
import java.util.List;

class CountIntervals {
    List<int[]> list = new ArrayList<>();
    int sum = 0;

    public CountIntervals() {
        // 想办法合并区间呗
    }

    public void add(int left, int right) {
        int leftIdx = 0;
        int rightIdx = list.size();
        while (leftIdx < rightIdx) {
            int midIdx = (rightIdx - leftIdx) / 2 + leftIdx;
            if (left >= list.get(midIdx)[0]) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx;
            }
        }
        leftIdx = leftIdx > 0 ? leftIdx - 1 : 0;
        // 闭集，合并也是有讲究的
        for (int i = leftIdx; i < list.size(); i++) {
            int[] interval = list.get(i);
            if (interval[0] > right + 1) {
                // 可以加入了
                list.add(i, new int[]{left, right});
                sum += right - left + 1;
                return;
            } else if (interval[1] < left - 1) {
                continue;
            } else {
                left = Math.min(left, interval[0]); // 反正有交融，选择小的作为左边界
                right = Math.max(right, interval[1]); // 选择大的作为右边界
                sum -= (interval[1] - interval[0] + 1);
                list.remove(i);
                i--;
            }

        }
        list.add(new int[]{left, right});
        sum += right - left + 1;
    }

    public int count() {
        return sum;
    }
}