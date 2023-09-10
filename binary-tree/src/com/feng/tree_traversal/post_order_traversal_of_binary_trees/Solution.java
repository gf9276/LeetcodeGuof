package com.feng.tree_traversal.post_order_traversal_of_binary_trees;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> output = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        output.clear();
        dfs(root);

        return output;
    }

    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);
        output.add(root.val);

    }

}