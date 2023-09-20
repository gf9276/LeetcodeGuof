package com.guof.mathematics.roman_numeral_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Package: com.feng.mathematics.power_of_3
 * Description:
 *
 * @Author guof
 * @Create 2023/4/2 22:35
 * @Version 1.0
 */
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        // 先全部都列出来
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int integer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) // 截取两个
            {
                integer += map.get(s.substring(i, i + 2));
                i++;

            } else {
                integer += map.get(s.substring(i, i + 1));
            }
        }
        return integer;
    }
}