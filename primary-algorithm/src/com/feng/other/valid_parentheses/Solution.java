package com.feng.other.valid_parentheses;

import java.util.Stack;

/**
 * ClassName: Solution
 * Package: com.feng.other.valid_parentheses
 * Description:
 *
 * @Author guof
 * @Create 2023/4/3 22:09
 * @Version 1.0
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.add(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            // 匹配上了出栈，不然入栈
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            if ((stack.peek() == '(' && chars[i] == ')')
                    || (stack.peek() == '{' && chars[i] == '}')
                    || (stack.peek() == '[' && chars[i] == ']')) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
