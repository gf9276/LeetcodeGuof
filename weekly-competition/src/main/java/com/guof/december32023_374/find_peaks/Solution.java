package com.guof.december32023_374.find_peaks;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i + 1] && mountain[i] > mountain[i - 1]) {
                output.add(i);
            }
        }
        return output;
    }
}