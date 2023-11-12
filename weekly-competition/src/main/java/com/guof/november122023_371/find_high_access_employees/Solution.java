package com.guof.november122023_371.find_high_access_employees;


import java.util.*;

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> output = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> accessTime : access_times) {
            List<Integer> tmpList = map.getOrDefault(accessTime.get(0), new ArrayList<>());
            tmpList.add(Integer.parseInt(accessTime.get(1)));
            map.put(accessTime.get(0), tmpList);
        }
        for (String key : map.keySet()) {
            if (isHighAccess(map.get(key))) {
                output.add(key);
            }
        }
        return output;
    }

    public boolean isHighAccess(List<Integer> access_times) {
        Collections.sort(access_times); // 升序排列，合理
        // access_times 里是一个人一天内访问的时间，我们找连续个数大于3的就行了
        int left = 0;
        int right = 0;
        int output = 0;
        for (; right < access_times.size(); right++) {
            while (access_times.get(right) - access_times.get(left) >= 100) {
                left++;
            }
            output = Math.max(output, right - left + 1);
            if (output >= 3) {
                return true;
            }
        }
        return false;
    }
}