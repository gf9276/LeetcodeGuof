package com.guof.tree_and_graph.school_timetable2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
        }
        for (int[] prerequisite : prerequisites) {
            map.put(prerequisite[0], map.getOrDefault(prerequisite[0], 0) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) {
                queue.add(key);
            }
        }

        int[] output = new int[numCourses];
        int courseCnt = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            output[courseCnt] = curCourse;
            courseCnt++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == curCourse) {
                    int courseBefore = map.get(prerequisite[0]);
                    courseBefore--;
                    map.put(prerequisite[0], courseBefore);
                    if (courseBefore == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }

        if (courseCnt == numCourses) {
            return output;
        }
        return new int[0];
    }
}