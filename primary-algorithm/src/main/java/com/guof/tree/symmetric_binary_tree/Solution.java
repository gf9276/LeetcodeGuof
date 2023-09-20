package com.guof.tree.symmetric_binary_tree;

/**
 * ClassName: Solution
 * Package: com.feng.tree.symmetric_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/3/26 22:21
 * @Version 1.0
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) & isSymmetricHelper(left.right, right.left);
    }
}
