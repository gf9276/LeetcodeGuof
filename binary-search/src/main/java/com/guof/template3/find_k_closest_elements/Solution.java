package com.guof.template3.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 找的其实是左下角标
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (x - arr[mid] <= arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }


        List<Integer> output = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            output.add(arr[i]);
        }
        return output;
    }
}
