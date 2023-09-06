package com.feng.summary_and_discussion.gems_and_stones;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();


        char[] chars = stones.toCharArray();

        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }


        chars = jewels.toCharArray();


        int sum = 0;
        for (char c : chars) {
            if (map.containsKey(c)) {
                sum += map.get(c);
            }
        }
        return sum;

    }
}