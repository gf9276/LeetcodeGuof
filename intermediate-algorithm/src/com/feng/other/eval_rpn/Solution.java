package com.feng.other.eval_rpn;

import java.util.Stack;

/**
 * ClassName: Solution
 * Package: com.feng.other.eval_rpn
 * Description:
 *
 * @Author guof
 * @Create 2023/5/11 16:01
 * @Version 1.0
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        Stack<String> tmpStack = new Stack<>();


        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]); // 全部放入栈
        }


        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
            if (tmpStack.peek().equals("+")) {
                tmpStack.pop();
                int tmpValue = Integer.parseInt(tmpStack.pop()) + Integer.parseInt(tmpStack.pop());
                stack.push(String.valueOf(tmpValue));
            } else if (tmpStack.peek().equals("-")) {
                tmpStack.pop();
                int tmpValue = -Integer.parseInt(tmpStack.pop()) + Integer.parseInt(tmpStack.pop());
                stack.push(String.valueOf(tmpValue));
            } else if (tmpStack.peek().equals("*")) {
                tmpStack.pop();
                int tmpValue = Integer.parseInt(tmpStack.pop()) * Integer.parseInt(tmpStack.pop());
                stack.push(String.valueOf(tmpValue));
            } else if (tmpStack.peek().equals("/")) {
                tmpStack.pop();
                int tmpValue = (int) (1.0 / Double.parseDouble(tmpStack.pop()) * Double.parseDouble(tmpStack.pop()));
                stack.push(String.valueOf(tmpValue));
            }
        }
        return Integer.parseInt(tmpStack.pop());
    }
}