package com.feng.practical_application_design_key.letter_heterotopic_word_grouping;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            if (map.containsKey(String.valueOf(c))) {
                map.get(String.valueOf(c)).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(String.valueOf(c), tmp);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for (String key : map.keySet()) {
            output.add(map.get(key));
        }
        return output;
    }
}