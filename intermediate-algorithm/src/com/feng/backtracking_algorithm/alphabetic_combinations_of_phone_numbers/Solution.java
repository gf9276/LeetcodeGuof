package com.feng.backtracking_algorithm.alphabetic_combinations_of_phone_numbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.backtracking_algorithm.alphabetic_combinations_of_phone_numbers
 * Description:
 *
 * @Author guof
 * @Create 2023/4/11 23:09
 * @Version 1.0
 */
//class Solution {
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> res = new LinkedList<>(); // 为什么用链表呢
//
//        if (digits == null || digits.isEmpty())
//            return res;   // 如果为空，直接返回就好
//
//        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
//                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
//                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}}; // 对应的数字
//
//        res.add(""); // 后面要加的，这是返回的输出啊
//
//        while (true) // 当长度没到
//        {
//            assert res.peek() != null;
//            if (res.peek().length() == digits.length()) break;
//            String remove = res.poll(); // 后面会加回去的
//            assert remove != null;
//            char[] tmp_chars = tab[digits.charAt(remove.length()) - '2']; // 获取新的字符
//
//            for (char tmpChar : tmp_chars) {
//                res.add(remove + tmpChar);
//            }
//        }
//        return res;
//    }
//}

class Solution {
    char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}}; // 对应的数字

    public List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList<>();

        if (digits == null || digits.isEmpty())
            return output;   // 如果为空，直接返回就好

        dfs(output, new ArrayList<>(), digits);

        return output;
    }


    public void dfs(LinkedList<String> output, List<Character> tmpList, String digits) {
        if (tmpList.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : tmpList) {
                sb.append(c);
            }
            output.add(sb.toString());
            return;
        }

        int curNbr = digits.charAt(tmpList.size()) - '2';
        for (int i = 0; i < tab[curNbr].length; i++) {
            tmpList.add(tab[curNbr][i]);
            dfs(output, tmpList, digits);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}