package com.feng.linear_dp.single_string_problem_other_single_string_dpi_problems.longest_valid_parentheses;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackIdx = new Stack<>();
        int[] dp = new int[s.length()];
        int maxLength = 0;

        if (s.length() <= 1) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                    stackIdx.push(i);
                }
                continue;
            }
            // 不为空
            if (stack.peek() == '(' && s.charAt(i) == ')') {
                // 左右括号，直接抵消
                stack.pop();
                int lastIdx = stackIdx.pop();
                dp[i] = i - lastIdx + 1 + (lastIdx >= 1 ? dp[lastIdx - 1] : 0);
                maxLength = Math.max(maxLength, dp[i]);
            } else {
                // 没法抵消就直接插入
                stack.push(s.charAt(i));
                stackIdx.push(i);
            }

        }
        return maxLength;
    }
}