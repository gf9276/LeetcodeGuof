package com.guof.cmp_2024_01_07_379.max_partitions_after_operations;

import java.util.*;

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        if (k == 26) {
            // 秒了
            return 1;
        }
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }
        Set<Character> set = new HashSet(characters);

        if (k > set.size()) {
            // 变一个也就不回来
            return 1;
        }
        int[] charCnt = new int[27];
        int position = -1;

        for (int i = 0; i < characters.size(); i++) {
            if (i > 0 && i < characters.size() - 1) {
                if (characters.get(i) == characters.get(i - 1) && characters.get(i) == characters.get(i + 1)) {
                    if (position != -1) {
                        characters.set(position, s.charAt(position));
                    }
                    characters.set(i, (char) ('a' + 26));
                    break;
                }
            }
            if (position == -1 && charCnt[characters.get(i) - 'a'] != 0) {
                characters.set(i, (char) ('a' + 26)); // 隔断符
                position = i;
            }
            charCnt[characters.get(i) - 'a']++;
        }

        int output = 0;
        set.clear();
        for (Character character : characters) {
            if (set.size() == k && !set.contains(character)) {
                // 爆了
                set = new HashSet<>(Collections.singletonList(character)); // 归零
                output++;
            } else {
                set.add(character); // 没爆就加进来呗
            }
        }
        return output + 1;
    }
}
