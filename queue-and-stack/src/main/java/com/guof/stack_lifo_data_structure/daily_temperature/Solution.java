package com.guof.stack_lifo_data_structure.daily_temperature;


import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();


        int days = temperatures.length;
        int[] output = new int[days];
        output[days - 1] = 0;
        stack.add(0);

        for (int i = 1; i < days; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int tmp = stack.pop();
                output[tmp] = i - tmp;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            output[stack.pop()] = 0;
        }
        return output;
    }
}