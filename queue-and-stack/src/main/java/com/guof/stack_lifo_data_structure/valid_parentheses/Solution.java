package com.guof.stack_lifo_data_structure.valid_parentheses;


import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // 消消乐谁不会啊
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();

        for (char value : c) {
            if (!stack.isEmpty()) {
                Character top = stack.peek();
                if ((top == '{' && value == '}') || (top == '(' && value == ')') || (top == '[' && value == ']')) {
                    stack.pop();
                    continue;
                }
            }
            stack.add(value);
        }

        return stack.isEmpty();
    }
}