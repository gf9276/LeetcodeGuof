package com.guof.tree_and_graph.count_smaller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    Integer[] output;

    public List<Integer> countSmaller(int[] nums) {
        output = new Integer[nums.length];
        Arrays.fill(output, 0);
        int[] idx = new int[nums.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        mergeSort(0, nums.length - 1, nums, idx);
        return new ArrayList<>(Arrays.asList(output));
    }


    public void mergeSort(int left, int right, int[] nums, int[] numsIdxs) {
        // 终止条件，只剩下一个节点，就直接退出，分个jb
        if (left >= right) {
            return;
        }
        // 获取中间端点
        int mid = (right - left) / 2 + left;
        // 递归，接着分
        mergeSort(left, mid, nums, numsIdxs);
        mergeSort(mid + 1, right, nums, numsIdxs);

        // 合并 left 到 mid, mid+1 到 right
        int[] tmpArray = new int[right - left + 1];
        int[] tmpIdxsArray = new int[right - left + 1];
        int[] tmpOutput = new int[mid + 1 - left];

        // tmp数组的下角标
        int tmpArrayIdx = 0;
        int moveLeft = left;
        int moveRight = mid + 1;

        // 合并启动，要升序排列
        while (moveLeft <= mid && moveRight <= right) {
            if (nums[moveLeft] > nums[moveRight]) {
                // 如果左边的比右边的大，那么，左边的逆序列多一个，右边的索引++
                tmpOutput[moveLeft - left]++;
                tmpIdxsArray[tmpArrayIdx] = numsIdxs[moveRight];
                tmpArray[tmpArrayIdx++] = nums[moveRight++];
            } else {
                // 如果右边的比左边的大或者等于左边的，那么，左边的要入队了，并且，继承前一个的逆序列数量
                tmpIdxsArray[tmpArrayIdx] = numsIdxs[moveLeft];
                tmpArray[tmpArrayIdx++] = nums[moveLeft++];
                if (moveLeft - left > 0 && moveLeft <= mid) {
                    // 继承前者
                    tmpOutput[moveLeft - left] = tmpOutput[moveLeft - left - 1];
                }
            }
        }

        // 下面两种情况只会发生一种
        while (moveLeft <= mid) {
            // 左边多出来了，由于右边的已经没有了，所以直接继承
            tmpIdxsArray[tmpArrayIdx] = numsIdxs[moveLeft];
            tmpArray[tmpArrayIdx++] = nums[moveLeft++];
            if (moveLeft - left > 0 && moveLeft <= mid) {
                // 继承前者
                tmpOutput[moveLeft - left] = tmpOutput[moveLeft - left - 1];
            }
        }

        while (moveRight <= right) {
            // 右边多出来了，无所谓，直接入队列即可
            tmpIdxsArray[tmpArrayIdx] = numsIdxs[moveRight];
            tmpArray[tmpArrayIdx++] = nums[moveRight++];
        }

        // 赋值
        if (right + 1 - left >= 0) System.arraycopy(tmpArray, 0, nums, left, right + 1 - left);
        for (int i = left; i <= mid; i++) {
            output[numsIdxs[i]] += tmpOutput[i - left];
        }
        if (right + 1 - left >= 0) System.arraycopy(tmpIdxsArray, 0, numsIdxs, left, right + 1 - left);
    }
}