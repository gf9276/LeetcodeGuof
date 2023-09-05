package com.feng.practical_application_hash_set.happy_number;

import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedSet = new HashSet<>();

        int curN = n;
        int change = curN;
        visitedSet.add(change);
        while (change != 1) {
            int sum = 0;
            while (change != 0) {
                sum += (change % 10) * (change % 10);
                change /= 10;
            }
            if (visitedSet.contains(sum)) {
                return false;
            }
            change = sum;
            visitedSet.add(change);
        }

        return true;
    }
}