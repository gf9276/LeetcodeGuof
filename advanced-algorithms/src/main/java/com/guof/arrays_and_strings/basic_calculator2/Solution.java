package com.guof.arrays_and_strings.basic_calculator2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public int calculate(String s) {
        Map<Character, Integer> map = new HashMap<>(); // 存放优先级
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);

        // 怎么变成逆波兰啊，算了，先直接实现吧
        char[] cs = s.toCharArray();
        Stack<String> stackD = new Stack<>(); // 放置数字
        Stack<Character> stackC = new Stack<>(); // 防止符号

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                // 跳过空格
                continue;
            } else if (Character.isDigit(s.charAt(i))) {
                // 添加数字
                int curNum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    curNum = curNum * 10 + (s.charAt(i) - '0');
                }
                stackD.add(String.valueOf(curNum));
            } else {
                // 处理符号位
                while (!stackC.isEmpty() && map.get(stackC.peek()) >= map.get(s.charAt(i))) {
                    int nbr2 = Integer.parseInt(stackD.pop());
                    int nbr1 = Integer.parseInt(stackD.pop());
                    char tmp = stackC.pop();
                    if (tmp == '+') {
                        stackD.add(String.valueOf(nbr1 + nbr2));
                    } else if (tmp == '*') {
                        stackD.add(String.valueOf(nbr1 * nbr2));
                    } else if (tmp == '/') {
                        stackD.add(String.valueOf(nbr1 / nbr2));
                    } else if (tmp == '-') {
                        stackD.add(String.valueOf(nbr1 - nbr2));
                    }
                }
                stackC.add(s.charAt(i));
            }
        }


        while (!stackC.isEmpty()) {
            int nbr2 = Integer.parseInt(stackD.pop());
            int nbr1 = Integer.parseInt(stackD.pop());
            char tmp = stackC.pop();
            if (tmp == '+') {
                stackD.add(String.valueOf(nbr1 + nbr2));
            } else if (tmp == '*') {
                stackD.add(String.valueOf(nbr1 * nbr2));
            } else if (tmp == '/') {
                stackD.add(String.valueOf(nbr1 / nbr2));
            } else if (tmp == '-') {
                stackD.add(String.valueOf(nbr1 - nbr2));
            }
        }
        return Integer.parseInt(stackD.peek());
    }
}