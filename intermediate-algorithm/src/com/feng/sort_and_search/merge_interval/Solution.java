package com.feng.sort_and_search.merge_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> outputList = new ArrayList<>();

        int first;
        int end;
        for (int i = 0; i < intervals.length; i++) {
            first = intervals[i][0]; // 等于第一个的开头
            end = intervals[i][1]; // 等于第一个的结尾
            while (i < intervals.length - 1) {
                // 如果发现下一个的开头小于等于当前的结尾，那么要重新划定结尾
                if (intervals[i + 1][0] <= end) {
                    end = Math.max(intervals[i + 1][1], end);
                    i++; // 接着挪到下一个
                } else {
                    // 反之，直接退出
                    break;
                }
            }
            outputList.add(new int[]{first, end}); // 记录一下
        }

        int[][] output = new int[outputList.size()][2];
        for (int i = 0; i < outputList.size(); i++) {
            output[i] = outputList.get(i);
        }

        return output;
    }
}