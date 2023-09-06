package com.feng.practical_application_design_key.finding_duplicate_subtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<TreeNode> output = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return output;
    }

    public String dfs(TreeNode root) {
        if (root == null) return "#";

        String s = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        if (!map.containsKey(s)) {
            map.put(s, 1);
        } else {
            map.put(s, map.get(s) + 1);
        }

        if (map.get(s) == 2) output.add(root);

        return s;
    }
}