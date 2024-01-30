package com.guof.minimum_seconds;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        // 选一个频率最高的就行了
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums.get(i))) {
                map.put(nums.get(i), new ArrayList<>());
            }
            map.get(nums.get(i)).add(i);
        }
        if (map.size() == 1) {
            return 0;
        }
        int output = 0x3f3f3f3f;

        for (int key : map.keySet()) {
            List<Integer> curList = map.get(key);
            int maxTime = getMaxTime(curList, n);
            output = Math.min(output, maxTime);
        }
        return output;
    }

    private static int getMaxTime(List<Integer> curList, int n) {
        int maxTime = 1;
        if (curList.size() == 1) {
            maxTime = n / 2;
        } else {
            for (int i = 0; i < curList.size(); i++) {
                int lastIdx = (i - 1 + curList.size()) % curList.size();
                int nextIdx = (i + 1 + curList.size()) % curList.size();
                int tmp1 = ((curList.get(nextIdx) - curList.get(i) + n) % n) / 2;
                int tmp2 = ((curList.get(i) - curList.get(lastIdx) + n) % n) / 2;
                int tmp = Math.max(tmp1, tmp2);
                maxTime = Math.max(tmp, maxTime);
            }
        }
        return maxTime;
    }
}