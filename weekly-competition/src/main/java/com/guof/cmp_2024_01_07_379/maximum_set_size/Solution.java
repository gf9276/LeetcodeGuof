package com.guof.cmp_2024_01_07_379.maximum_set_size;

import java.util.*;

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 移除一半的元素，先移除重复元素
        Set<Integer> set1 = new HashSet<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(Arrays.stream(nums2).boxed().toArray(Integer[]::new)));

        if (set1.size() <= n / 2 && set2.size() <= n / 2) {
            set1.addAll(set2);
            return set1.size();
        }

        List<Integer> intersectionList = new ArrayList<>(set1);
        intersectionList.retainAll(set2); // 这是交集


        while ((set1.size() > n / 2 || set2.size() > n / 2) && !intersectionList.isEmpty()) {
            Set<Integer> curSet = set1.size() >= set2.size() ? set1 : set2; // 删除长度长的
            curSet.remove(intersectionList.get(0));
            intersectionList.remove(0); // 删除第0个
        }

        if (!intersectionList.isEmpty()) {
            // 还有多的，说明重复了
            set1.addAll(set2);
            return set1.size();
        }

        // 没有多的，说明两者之间肯定不存在交集了，但是可能还有一个或者两个数量都很多
        return Math.min(set1.size(), n / 2) + Math.min(set2.size(), n / 2);
    }
}