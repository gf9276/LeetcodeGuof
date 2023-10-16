package com.guof.october142023_115.last_visited_integers;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> output = new ArrayList<>();

        // 感觉不需要stack
        List<Integer> list = new ArrayList<>();
        int curIdx = -1; // 最近一个数字的下角标

        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).equals("prev")) {
                list.add(Integer.parseInt(words.get(i))); // 如果是数字直接拉入
                curIdx = list.size() - 1; // 并且更新下角标
            } else {
                if (curIdx == -1) {
                    output.add(-1);
                } else {
                    output.add(list.get(curIdx));
                    curIdx--;
                }
            }
        }
        return output;
    }
}