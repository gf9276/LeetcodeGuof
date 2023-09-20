package com.guof.stack_lifo_data_structure.evaluate_inverse_polish_expression;


import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String s : tokens) {
            if (set.contains(s)) {
                Integer value1 = Integer.valueOf(stack.pop());
                Integer value2 = Integer.valueOf(stack.pop());
                Integer tmp = null;
                if (Objects.equals(s, "+")) {
                    tmp = value2 + value1;
                }
                if (Objects.equals(s, "-")) {
                    tmp = value2 - value1;
                }
                if (Objects.equals(s, "*")) {
                    tmp = value2 * value1;
                }
                if (Objects.equals(s, "/")) {
                    tmp = value2 / value1;
                }
                stack.add(String.valueOf(tmp));
            } else {
                stack.add(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}