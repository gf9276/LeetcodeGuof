package com.guof.binary_search.others.lc_2070;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // 排序，按照钱和元素
        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] ans = new int[queries.length];

        Integer[] idxs = new Integer[queries.length];
        Arrays.setAll(idxs, i -> i);
        Arrays.sort(idxs, Comparator.comparingInt(a -> queries[a]));

        int max = 0;

        int right = 0;
        for (int i = 0; i < queries.length; i++) {
            while (right < items.length && items[right][0] <= queries[idxs[i]]) {
                max = Math.max(items[right][1], max);
                right++;
            }
            ans[idxs[i]] = max;
        }
        return ans;
    }
}