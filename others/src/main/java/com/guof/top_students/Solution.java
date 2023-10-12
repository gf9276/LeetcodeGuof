package com.guof.top_students;


import java.util.*;

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // map储存分数
        Map<String, Integer> map = new HashMap<>();

        for (String s : positive_feedback) {
            map.put(s, 3);
        }
        for (String s : negative_feedback) {
            map.put(s, -1);
        }

        // 使用二维数组，方便排序
        int[][] students = new int[report.length][2]; // 0 是 id，1 是分数

        // 计算分数
        for (int i = 0; i < report.length; i++) {
            String[] curReports = report[i].split(" ");
            students[i][0] = student_id[i];
            for (String aCurReport : curReports) {
                students[i][1] += map.getOrDefault(aCurReport, 0);
            }
        }

        Arrays.sort(students, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            output.add(students[i][0]);
        }
        return output;
    }
}