package com.guof.cmp_2024_01_14_380.beautiful_indices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    long[] tree;

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

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        // 直接把所有的都找出来得了
        List<Integer> iPoints;
        List<Integer> jPoints;
        List<Integer> output = new ArrayList<>();


        int[] nextA = getNext(a);
        int[] nextB = getNext(b);

        iPoints = strStr(s, a, nextA);
        jPoints = strStr(s, b, nextB);

        tree = new long[s.length() + 1];
        for (int j : jPoints) {
            add(j + 1, 1);
        }

        for (int i : iPoints) {
            int top = Math.min(i + k + 1, tree.length - 1);
            int low = Math.max(i - k, 0);
            if (query(top) - query(low) > 0) {
                output.add(i);
            }
        }

        Collections.sort(output);
        return output;
    }


    public int[] getNext(String needle) {
        char[] T = needle.toCharArray();
        int jj = 0, k = -1;
        int[] next = new int[needle.length() + 1];
        next[jj] = k;
        while (jj < needle.length()) {
            if (k == -1 || T[jj] == T[k]) {
                jj++;
                k++;
                next[jj] = k;
            } else k = next[k];
        }
        return next;
    }

    public List<Integer> strStr(String haystack, String needle, int[] next) {
        List<Integer> output = new ArrayList<>();
        char[] T = needle.toCharArray();
        char[] S = haystack.toCharArray();


        //然后利用next数组就可使用KMP算法啦
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || S[i] == T[j]) {
                i++;         //继续对下一个字符比较
                j++;         //模式串向右滑动
            } else j = next[j];
            if (j == needle.length()) {
                output.add(i - j);
                j = next[j];
            }
        }
        return output;
    }
}