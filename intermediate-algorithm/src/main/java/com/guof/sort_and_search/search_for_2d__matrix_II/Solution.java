package com.guof.sort_and_search.search_for_2d__matrix_II;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.search_for_2d__matrix_II
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 16:13
 * @Version 1.0
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] begin = new int[]{matrix.length - 1, 0}; // 左下角开始

//        matrix[begin[0]][begin[1]]
        while (begin[0] < matrix.length && begin[0] >= 0 && begin[1] < matrix[0].length && begin[1] >= 0) {
            if (target > matrix[begin[0]][begin[1]]) {
                begin[1]++;
            } else if (target < matrix[begin[0]][begin[1]]) {
                begin[0]--;
            } else {
                return true;
            }
        }
        return false;
    }
}
