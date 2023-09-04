package com.feng.summary.string_decoding;


import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                stack2.clear();
                while (!stack.peek().equals("[")) {
                    stack2.push(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    sb.append(stack2.pop());
                }
                String str = sb.toString();
                sb = new StringBuilder();
                stack.pop();
                while (!stack.isEmpty() && stack.peek().toCharArray()[0] <= '9' && stack.peek().toCharArray()[0] >= '0') {
                    stack2.push(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    sb.append(stack2.pop());
                }

                int time = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    sb.append(str);
                }
                stack.push(sb.toString());

            } else {
                stack.push(s.substring(i, i + 1));
            }
        }
        stack2.clear();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }
        return sb.toString();

    }
}