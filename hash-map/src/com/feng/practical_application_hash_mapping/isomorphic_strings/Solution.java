package com.feng.practical_application_hash_mapping.isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        s = move2abcde(s);
        t = move2abcde(t);

        return s.equals(t);
    }


    public String move2abcde(String str) {
        Map<Character, Character> map = new HashMap<>();

        char[] chars = str.toCharArray();
        char nowLetter = 'a';

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], nowLetter++);
            }
            chars[i] = map.get(chars[i]);
        }

        return String.valueOf(chars);

    }
}