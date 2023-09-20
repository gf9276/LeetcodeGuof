package com.guof.practical_application_design_key.shift_string_grouping;

import java.util.*;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            char[] charArray = str.toCharArray();

            for (int i = charArray.length - 1; i >= 0; i--) {
                int tmp = charArray[i];
                tmp -= charArray[0];
                if (tmp < 0) tmp += ('z' - 'a' + 1);
                charArray[i] = (char) tmp;
            }

            String newStr = String.valueOf(charArray);

            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(newStr, tmp);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for (String key : map.keySet()) {
            output.add(map.get(key));
        }
        return output;
    }
}