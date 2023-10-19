package com.guof.words_typing;


import java.util.Arrays;

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // 不懂，这种题目有什么意义吗？

        int[] arr = new int[sentence.length]; // 以第 i 个字符串开头，可以放下几个字符串？
        Arrays.fill(arr, 1);

        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i].length() > cols) {
                // 一行都放不下这一个词
                return 0;
            }
            int curLen = sentence[i].length(); // 以sentence[i]作为开头，放了一个词之后的长度
            for (int j = i + 1; ; j++) {
                if (j == sentence.length) {
                    // 放完一行，从头开始
                    j = 0;
                }
                if (curLen + 1 + sentence[j].length() <= cols) {
                    // 如果这一行还能放得下sentence[j]，那就放下，并更新目前的字符长度
                    arr[i]++;
                    curLen = curLen + 1 + sentence[j].length();
                } else {
                    // 如果已经放不下了，那就吃屎去吧
                    break;
                }
            }
        }

        // 记录完了
        long sum = 0;
        for (int i = 1; i <= rows; i++) {
            sum += arr[(int) (sum % sentence.length)];
        }
        return (int) (sum / sentence.length);
    }
}