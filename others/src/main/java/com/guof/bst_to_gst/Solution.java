package com.guof.bst_to_gst;

class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        // 左边的都比他小，好，先计算一下所有节点的和
        dfs(root);
        return root;
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}