package com.guof.magical_string;


class Solution {
    static int[] arr = new int[100009]; // 确保没问题

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("01"); // 0作为前缀？哨兵？
        int last = 1; // last是指向当前计数队列的指针
        int j = 1; // j是指向原队列的指针
        for (; last <= arr.length; last++) {
            if (sb.charAt(last) == '1') {
                // 如果当前计数是1
                if (sb.charAt(j) == '1') {
                    // 当前原队列也是1，那么下一个只能是2（因为1个1嘛）
                    sb.append("2");
                } else {
                    // 原队列是“2”，那么下一个只能是1（因为一个2嘛）
                    sb.append("1");
                }
                j++;
            } else {
                // 如果计数当前是2
                if (sb.charAt(j) == '1') {
                    // 如果原队列是1，那么后面要加上12（只能有两个1，所以来个2封锁一下）
                    sb.append("12");
                } else {
                    sb.append("21");
                }
                j += 2;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1];
            if (sb.charAt(i) == '1') {
                arr[i]++;
            }
        }
    }


    public int magicalString(int n) {
        // 边走边动
        return arr[n];
    }
}