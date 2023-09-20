package com.guof.stack_and_depth_first_search.middle_order_traversal_of_binary_trees;


import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        list.clear();
        dfs(root);
        return list;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

    }
}