package com.feng.other.yang_hui_triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.other.yang_hui_triangle
 * Description:
 *
 * @Author guof
 * @Create 2023/4/3 22:01
 * @Version 1.0
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            row.add(0, 1); // 在最前面，插入1，整体长度也加一了
            int row_size = row.size();
            for (int j = 1; j < row_size - 1; j++) {
                row.set(j, row.get(j + 1) + row.get(j));
            }
            res.add(new ArrayList<>(row));

        }
        return res;
    }
}