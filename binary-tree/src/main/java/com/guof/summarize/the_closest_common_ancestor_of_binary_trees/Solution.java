package com.guof.summarize.the_closest_common_ancestor_of_binary_trees;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // root == p 或者 root == q 说明 root 是共同根节点
            // root为空，说明不在这一边
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // 都为空，说明p 和 q一个在左一个在右
        return root;
    }
}