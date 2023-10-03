package com.guof.mathematics.maximum_number;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //重写compare方法，最好加注解，不加也没事
        Arrays.sort(newNums, new Comparator<Integer>() {
            //重写compare方法，最好加注解，不加也没事
            public int compare(Integer a, Integer b) {
                //返回值>0交换
                String string1 = String.valueOf(a) + String.valueOf(b);
                String string2 = String.valueOf(b) + String.valueOf(a);

                int str1Idx = 0;
                int str2Idx = 0;
                while (string1.charAt(str1Idx) == '0') {
                    str1Idx++;
                    if (str1Idx == string1.length()) {
                        break;
                    }
                }
                while (string2.charAt(str2Idx) == '0') {
                    str2Idx++;
                    if (str2Idx == string2.length()) {
                        break;
                    }
                }

                int s1Len = string1.length() - str1Idx;
                int s2Len = string2.length() - str2Idx;

                if (s1Len != s2Len || s1Len == 0) {
                    return s2Len - s1Len;
                } else {
                    while (string1.charAt(str1Idx) == string2.charAt(str2Idx)) {
                        str1Idx++;
                        str2Idx++;
                        if (str1Idx == string1.length()) {
                            return 0;
                        }
                    }
                    return string2.charAt(str2Idx) - string1.charAt(str1Idx);
                }
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        int tmp = 0;
        while (newNums[tmp] == 0) {
            tmp++;
            if (tmp == newNums.length) {
                return "0";
            }
        }
        for (int i = tmp; i < newNums.length; i++) {
            stringBuilder.append(newNums[i]);
        }
        return stringBuilder.toString();
    }
}