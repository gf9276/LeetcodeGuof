package com.guof.tree_and_graph.nbr_of_provinces;


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
        int[][] input = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        solution.findCircleNum(input);
    }
}
