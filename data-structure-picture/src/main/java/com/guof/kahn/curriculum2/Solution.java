package com.guof.kahn.curriculum2;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in_degree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            in_degree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        int[] output = new int[numCourses];
        int curClassIdx = 0;

        while (!queue.isEmpty()) {
            int curClass = queue.poll();
            output[curClassIdx++] = curClass;
            for (int[] prerequisite : prerequisites) {
                if (curClass == prerequisite[1]) {
                    in_degree[prerequisite[0]]--;
                    if (in_degree[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        if (curClassIdx < numCourses) {
            return new int[0];
        } else {
            return output;
        }
    }
}