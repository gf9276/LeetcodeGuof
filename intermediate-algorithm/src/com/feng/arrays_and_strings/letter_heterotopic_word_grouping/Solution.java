package com.feng.arrays_and_strings.letter_heterotopic_word_grouping;

import java.util.*;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 18:41
 * @Version 1.0
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 直接排序

//        String[] reserve = new String[strs.length];
//        System.arraycopy(strs, 0, reserve, 0, strs.length); // 好像只是引用啊
//
//        for (int i = 0; i < strs.length; i++) {
//            char[] tmp = strs[i].toCharArray();
//            Arrays.sort(tmp);
//            strs[i] = Arrays.toString(tmp);
//        }
//        List<List<String>> res = new ArrayList<>();
//        List<String> a_res = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            if (strs[i] == null) {
//                continue;
//            }
//            a_res.clear();
//            a_res.add(reserve[i]);
//            for (int j = i + 1; j < strs.length; j++) {
//                if (strs[j] != null && strs[j].equals(strs[i])) {
//                    a_res.add(reserve[j]);
//                    strs[j] = null;
//                }
//            }
//            res.add(new ArrayList<>(a_res));
//        }
//        return res;
//    }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = Arrays.toString(tmp);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}