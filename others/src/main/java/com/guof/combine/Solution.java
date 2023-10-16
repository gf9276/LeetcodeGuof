package com.guof.combine;


import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> output;

    public List<List<Integer>> combine(int n, int k) {
        // 这种遍历的，真的就是只是遍历啊
        output = new ArrayList<>();

        dfs(new ArrayList<>(), n, k, 1);

        return output;
    }

    public void dfs(List<Integer> tmpList, int n, int k, int curNbr) {
        if (tmpList.size() == k) {
            // 够数量了
            output.add(new ArrayList<>(tmpList));
            return;
        }
        if (curNbr > n) {
            // 这个数字超过范围了，不能要
            return;
        }

        tmpList.add(curNbr);
        dfs(tmpList, n, k, curNbr + 1);
        tmpList.remove(tmpList.size() - 1);

        dfs(tmpList, n, k, curNbr + 1);
    }
}