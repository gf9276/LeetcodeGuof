package com.guof.cmp_2024_01_21_381.minimum_pushes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumPushes(String word) {
        // 统计26个英文字母出现的次数
        Integer[] cnts = new Integer[26];
        Arrays.fill(cnts, 0);
        for (char c : word.toCharArray()) {
            cnts[c - 'a']++;
        }

        // 8 个位置可以放置字母，8个位置放置26个字母
        int output = 0;

        Arrays.sort(cnts, (a, b) -> b - a); // 直接从大到小排序

        int[] sum = new int[4];

        for (int i = 0; i < 26; i++) {
            sum[i / 8] += cnts[i];
        }

        for (int i = 0; i < sum.length; i++) {
            output += (i + 1) * sum[i];
        }
        return output;
    }
}