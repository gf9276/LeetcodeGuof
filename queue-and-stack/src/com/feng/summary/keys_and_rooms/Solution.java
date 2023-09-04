package com.feng.summary.keys_and_rooms;


import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        dfs(set, rooms, 0);

        for (int i = 0; i < rooms.size(); i++) {
            if (!set.contains(i)) return false;
        }

        return true;
    }

    public void dfs(Set<Integer> visitedSet, List<List<Integer>> rooms, Integer nowRoom) {
        // 不重复进入
        if (visitedSet.contains(nowRoom)) return;

        visitedSet.add(nowRoom);
        for (Integer nextRoom : rooms.get(nowRoom)) {
            dfs(visitedSet, rooms, nextRoom);
        }
    }
}