package com.guof.max_product;


class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n]; // 我夜观天象，字母有26个，int有32位，完美啊。只要两个数字与一下，不是0，那就是垃圾

        // 记录每个单词的情况
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char c : chars) {
                arr[i] |= (1 << (c - 'a'));
            }
        }

        int output = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    output = Math.max(output, words[i].length() * words[j].length());
                }
            }
        }

        return output;
    }
}