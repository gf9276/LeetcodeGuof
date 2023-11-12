package com.guof.november122023_371.min_operations;

class Solution {
    int output = Integer.MAX_VALUE;
    int[] nums1;
    int[] nums2;
    int lastOne1;
    int lastOne2;

    public int minOperations(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.lastOne1 = nums1[nums1.length - 1];
        this.lastOne2 = nums2[nums2.length - 1];

        dfs(false, 0, 0);
        dfs(true, 0, 0);

        return output == Integer.MAX_VALUE ? -1 : output;
    }

    public void dfs(boolean exchangeLast, int curIdx, int curNbr) {
        // exchangeLast表示是否交换最后一个位置
        if (curIdx == nums1.length - 1) {
            // 到了最后一个位置了
            if (exchangeLast) {
                output = Math.min(output, curNbr + 1);
            } else {
                output = Math.min(output, curNbr);
            }
            return;
        }

        // 能不换就不换
        if (nums1[curIdx] <= (exchangeLast ? lastOne2 : lastOne1) && nums2[curIdx] <= (exchangeLast ? lastOne1 : lastOne2)) {
            // 不需要换
            dfs(exchangeLast, curIdx + 1, curNbr);
        } else if (nums1[curIdx] <= (exchangeLast ? lastOne1 : lastOne2) && nums2[curIdx] <= (exchangeLast ? lastOne2 : lastOne1)) {
            // 到这里，说明不满足第一个条件，那必须得换，换当前值啊
            dfs(exchangeLast, curIdx + 1, curNbr + 1);
        } else {
            // 上面两个都不满足，吃屎去吧
            return;
        }
    }
}