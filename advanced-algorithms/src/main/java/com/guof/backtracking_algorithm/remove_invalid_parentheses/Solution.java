package com.guof.backtracking_algorithm.remove_invalid_parentheses;

import java.util.*;

class Solution {
    Set<String> output;

    public List<String> removeInvalidParentheses(String s) {
        output = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        List<Character> bracketList = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add('(');
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    bracketList.add(')');
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            bracketList.add(stack.pop());
        }

        // bracketList 里是要删除的括号顺序
        dfs(bracketList, 0, s.toCharArray());
        return new ArrayList<>(output);
    }

    public void dfs(List<Character> bracketList, int idx, char[] chars) {
        if (bracketList.isEmpty()) {
            // 空的检查一遍，没问题就添加，有问题就滚
            if (validBracket(chars)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : chars) {
                    if (c != '#') {
                        stringBuilder.append(c);
                    }
                }
                output.add(stringBuilder.toString());
            }
            return;
        }
        if (idx >= chars.length) {
            return;
        }

        //  情况1 删除当前字符
        char curChar = chars[idx];
        if (bracketList.get(0) == curChar) {
            chars[idx] = '#'; // 变成特殊字符
            bracketList.remove(0); // 把第零个删掉
            dfs(bracketList, idx + 1, chars);

            // 恢复现场
            bracketList.add(0, curChar);
            chars[idx] = curChar;
        }

        // 情况2 不删除当前字符
        dfs(bracketList, idx + 1, chars);
    }

    public boolean validBracket(char[] chars) {
        // 判断是否为有效的
        int leftNbr = 0;
        int rightNbr = 0;

        for (char aChar : chars) {
            if (aChar == '(') {
                leftNbr++;
            } else if (aChar == ')') {
                rightNbr++;
            }

            if (leftNbr < rightNbr) {
                return false;
            }
        }
        return leftNbr == rightNbr;
    }
}