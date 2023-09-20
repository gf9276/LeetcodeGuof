package com.guof.summary_and_discussion.the_unique_abbreviation_of_a_word;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class ValidWordAbbr {

    Map<String, String> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String str : dictionary) {
            StringBuilder stringBuilder = new StringBuilder();
            int size = str.length() - 2;
            if (size != 0) {
                stringBuilder.append(str.charAt(0));
                stringBuilder.append(size);
                stringBuilder.append(str.charAt(str.length() - 1));
            } else {
                stringBuilder.append(str);
            }
            if (map.containsKey(stringBuilder.toString()) && !map.get(stringBuilder.toString()).equals(str)) {
                map.put(stringBuilder.toString(), "#######");
            } else {
                map.put(stringBuilder.toString(), str);
            }
        }
    }

    public boolean isUnique(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = word.length() - 2;
        if (size != 0) {
            stringBuilder.append(word.charAt(0));
            stringBuilder.append(size);
            stringBuilder.append(word.charAt(word.length() - 1));
        } else {
            stringBuilder.append(word);
        }

        boolean output = !map.containsKey(stringBuilder.toString()); // 不存在这个值，自然是独一无二的
        output |= map.containsKey(stringBuilder.toString()) && Objects.equals(map.get(stringBuilder.toString()), word); // 存在这个值，但是这个值和我是一样的

        return output;
    }
}