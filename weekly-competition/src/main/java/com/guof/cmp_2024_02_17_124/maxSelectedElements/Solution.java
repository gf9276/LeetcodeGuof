package com.guof.cmp_2024_02_17_124.maxSelectedElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return 1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int tmp = map.getOrDefault(num + 1, 0); // 默认长度为0
            tmp = Math.max(tmp, map.getOrDefault(num, 0) + 1);
            map.put(num + 1, tmp);


            tmp = map.getOrDefault(num, 0); // 默认长度为0
            tmp = Math.max(tmp, map.getOrDefault(num - 1, 0) + 1);
            map.put(num, tmp);
        }

        int output = 0;
        for (int key : map.keySet()) {
            output = Math.max(output, map.get(key));
        }
        return output;

    }

}