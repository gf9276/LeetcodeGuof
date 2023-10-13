package com.guof.company_naming;


import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        // key是首字母
        Map<Character, Set<String>> map = new HashMap<>();

        // 统计字母 + 后缀
        for (String idea : ideas) {
            Set<String> set = map.getOrDefault(idea.charAt(0), new HashSet<>());
            set.add(idea.substring(1));
            map.put(idea.charAt(0), set);
        }

        // 统计差集 B-A
        long output = 0;
        for (Character key : map.keySet()) {
            for (Character key2 : map.keySet()) {
                if (key.equals(key2)) {
                    continue;
                }
                Set<String> set = new HashSet<>(map.get(key));
                Set<String> set2 = new HashSet<>(map.get(key2));
                set.removeAll(set2);
                int size = set.size();
                set2.removeAll(new HashSet<>(map.get(key)));
                int size2 = set2.size();
                output += (long) size * size2;
            }
        }
        return output;
    }
}