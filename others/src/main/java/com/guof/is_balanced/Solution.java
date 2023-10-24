package com.guof.is_balanced;


class Solution {
    boolean output = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return output;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            // 高度为0
            return 0;
        }
        if (!output) {
            // 无所谓了，已经输了
            return -1;
        }

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            output = false;
        }

        return Math.max(leftHeight, rightHeight) + 1; // 返回当前root的高度
    }
}