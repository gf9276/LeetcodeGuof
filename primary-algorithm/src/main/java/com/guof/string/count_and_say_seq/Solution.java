package com.guof.string.count_and_say_seq;

/**
 * ClassName: Solution
 * Package: com.feng.string.count_and_say_seq
 * Description:
 *
 * @Author guof
 * @Create 2023/3/24 17:26
 * @Version 1.0
 */
class Solution {
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String str = "";
        str = str + getNext(countAndSay(n - 1));

        return str;
    }


    private String getNext(String str) {
        StringBuilder next_str = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            int cnt = 0;  // 记录当前值和个数
            int now_value = 0;

            // 计算个数和值
            now_value = str.charAt(i);
            for (; ; ) {
                if (i + cnt < str.length() && now_value == str.charAt(i + cnt)) {
                    cnt++;
                } else {
                    break;
                }
            }

            next_str.append(cnt).append(now_value - '0');
            i = i + cnt; // 重置i的位置
        }
        return next_str.toString();
    }
}