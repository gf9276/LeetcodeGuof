package com.guof.november192023_372.minimum_steps;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int N = 10; // 懒得那啥了，直接固定好了
    long[] tree = new long[N];

    int lowbit(int x) {
        return x & -x;
    }

    long query(int x) {
        long output = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            output += tree[i];
        }
        return output;
    }

    void add(int idx, int value) {
        for (int i = idx; i < tree.length; i += lowbit(i)) {
            tree[i] += value;
        }
    }

    public List<Long> countSmaller(char[] nums) {
        for (char num : nums) {
            add(num - '0' + 1, 1);
        }

        List<Long> output = new ArrayList<>();
        for (char num : nums) {
            add(num - '0' + 1, -1); // 删掉当前的
            output.add(query(num - '0'));
        }
        return output;
    }

    public long minimumSteps(String s) {
        // 101110
        // 011110  011101 011011 010111 001111
        // 其实就是求逆序对的数量
        List<Long> tmpList = countSmaller(s.toCharArray());

        long output = 0;
        for (Long aLong : tmpList) {
            output += aLong;
        }
        return output;
    }
}