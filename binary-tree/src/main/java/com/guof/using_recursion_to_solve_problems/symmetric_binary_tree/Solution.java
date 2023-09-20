package com.guof.using_recursion_to_solve_problems.symmetric_binary_tree;

class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}