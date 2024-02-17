package com.guof.cmp_2024_02_17_124.perform_an_operation_to_make_the_string_empty;

import java.util.*;

class Solution {
    public String lastNonEmptyString(String s) {
        List<Integer>[] lists = new ArrayList[26]; // 26个英文字母
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        int idx = 0;
        for (char c : s.toCharArray()) {
            lists[c - 'a'].add(idx++);
        }

        List<Integer> maxList = new ArrayList<>();
        int maxSize = -1;
        for (List<Integer> list : lists) {
            maxSize = Math.max(maxSize, list.size());
        }

        for (int i = 0; i < lists.length; i++) {
            if (lists[i].size() == maxSize) {
                maxList.add(i);
            }
        }
        List<Integer[]> tmp = new ArrayList<>();
        for (Integer integer : maxList) {
            for (int j = maxSize - 1; j < maxSize; j++) {
                tmp.add(new Integer[]{lists[integer].get(j), integer});
            }
        }
        tmp.sort(Comparator.comparingInt(a -> a[0])); // 升序排序

        StringBuilder output = new StringBuilder();

        for (Integer[] integers : tmp) {
            output.append((char) (integers[1] + 'a'));
        }
        return output.toString();

    }
}