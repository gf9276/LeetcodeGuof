package com.guof.cmp_2024_03_03_387.resultarray2;

import java.util.*;

class Solution {

    int lowbit(int x) {
        return x & -x;
    }

    int query(int x, int[] tree) {
        int output = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            output += tree[i];
        }
        return output;
    }

    void add(int idx, int value, int[] tree) {
        for (int i = idx; i < tree.length; i += lowbit(i)) {
            tree[i] += value;
        }
    }

    public int[] resultArray(int[] nums) {
        int tmp = 1;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        Map<Integer, Integer> map = new HashMap<>(); // 映射关系
        for (int i = 1; i < list.size() + 1; i++) {
            map.put(list.get(i - 1), i);
        }

        int maxSize = 1000009;
        int[] tree1 = new int[maxSize + 1];
        int[] tree2 = new int[maxSize + 1];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        add(map.get(nums[0]), 1, tree1);
        arr2.add(nums[1]);
        add(map.get(nums[1]), 1, tree2);

        for (int i = 2; i < nums.length; i++) {
            int cnt1 = query(maxSize, tree1) - query(map.get(nums[i]), tree1);
            int cnt2 = query(maxSize, tree2) - query(map.get(nums[i]), tree2);

            if (cnt1 > cnt2) {
                arr1.add(nums[i]);
                add(map.get(nums[i]), 1, tree1);
            } else if (cnt2 > cnt1) {
                arr2.add(nums[i]);
                add(map.get(nums[i]), 1, tree2);
            } else {
                if (arr1.size() <= arr2.size()) {
                    arr1.add(nums[i]);
                    add(map.get(nums[i]), 1, tree1);
                } else {
                    arr2.add(nums[i]);
                    add(map.get(nums[i]), 1, tree2);
                }
            }
        }

        int[] output = new int[nums.length];
        int idx = 0;
        for (int i : arr1) {
            output[idx++] = i;
        }
        for (int i : arr2) {
            output[idx++] = i;
        }
        return output;
    }
}