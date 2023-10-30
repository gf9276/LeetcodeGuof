package com.guof.october282023_116.min_changes;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minChanges(String s) {
        // 我来分割
        List<StringBuilder> list = new ArrayList<>();
        int left = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            list.add(new StringBuilder(s.substring(left, i)));
            left = i;
        }

        // 所有的都被我抓起来了
        // 我觉得贪心挺好的
        int step = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 == 1) {
                step++;
                list.get(i).delete(list.get(i).length() - 1, list.get(i).length());
                if (i < list.size() - 1) {
                    list.get(i + 1).append(list.get(i + 1).charAt(0));
                }
            }
        }
        return step;
    }
}