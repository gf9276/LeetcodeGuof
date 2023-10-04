package com.guof.mathematics.max_number_of_points_on_a_straight_line;


/**
 * ClassName: Test
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:14
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        solution.maxPoints(input);
    }
}
