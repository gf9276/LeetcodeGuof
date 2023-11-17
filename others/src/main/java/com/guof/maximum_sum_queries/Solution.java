package com.guof.maximum_sum_queries;


import java.util.*;

class Solution {
    int[] tree; // 记得留一个空位
    int[][] nums;

    int lowbit(int x) {
        return x & -x;
    }

    int query(int x) {
        // 询问区间里的最大值
        int output = -1;
        for (int i = x; i > 0; i -= lowbit(i)) {
            output = Math.max(output, tree[i]);
        }
        return output;
    }

    void update(int idx, int value) {
        // 更新idx位置的最大值为value，爬树
        for (int i = idx; i < tree.length; i += lowbit(i)) {
            if (tree[i] >= value) {
                break; // 后面不用爬了
            }
            tree[i] = value;
        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] output = new int[queries.length];
        // 这是一个二维偏序问题？
        nums = new int[nums1.length][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        tree = new int[nums1.length + 2]; // nums1和nums2的长度是一样的，无所谓~ +2是防止末尾
        Arrays.fill(tree, -1);

        Arrays.sort(nums, (a, b) -> -a[0] + b[0]); // 按照nums1升序排列
        Integer[] nums2Integer = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2Integer, (a, b) -> b - a); // 降序排列，方便
        nums2 = Arrays.stream(nums2Integer).mapToInt(Integer::valueOf).toArray();

        Integer[] queriesIdx = new Integer[queries.length];
        for (int i = 0; i < queriesIdx.length; i++) {
            queriesIdx[i] = i;
        }
        Arrays.sort(queriesIdx, (i, j) -> queries[j][0] - queries[i][0]); // idx从大到小排序

        int j = 0;
        for (int curQueryIdx : queriesIdx) {
            // 把符合条件的一步步放入到树状数组中
            int x = queries[curQueryIdx][0];
            int y = queries[curQueryIdx][1];

            for (; j < nums.length && nums[j][0] >= x; j++) {
                // 符合条件的准备放入
                int k = search(nums2, nums[j][1]); // 找到他的位置！
                update(k + 1, nums[j][0] + nums[j][1]);
            }
            int k = search(nums2, y);
            // 不一定有y，不过无所谓，我早已经预料到了
            output[curQueryIdx] = query(k + 1);
        }
        return output;
    }

    int search(int[] num, int value) {
        // 在num中找到小于等于value的第一个

        int left = -1;
        int right = num.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left + 1;
            if (num[mid] >= value) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}