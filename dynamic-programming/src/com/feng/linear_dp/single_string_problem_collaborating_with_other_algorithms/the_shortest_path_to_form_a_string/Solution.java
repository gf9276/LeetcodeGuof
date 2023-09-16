package com.feng.linear_dp.single_string_problem_collaborating_with_other_algorithms.the_shortest_path_to_form_a_string;

class Solution {
    public int shortestWay(String source, String target) {
        // 先用双指针试一次
        int p1 = 0;
        int p2 = 0;
        int output = 0;

        while (p2 < target.length()) {
            int begin = p1;
            while (p1 < source.length() && target.charAt(p2) != source.charAt(p1)) {
                // 找到相同的为止
                p1++;
            }
            if (p1 == source.length()) {
                if (begin == 0) {
                    return -1;
                } else {
                    p1 = 0;
                    output += 1;
                    continue;
                }
            }
            p1++;
            p2++;
            if (p2 == target.length()) {
                return output + 1;
            }
            if (p1 == source.length()) {
                p1 = 0;
                output += 1;
            }
        }
        return output;
    }
}