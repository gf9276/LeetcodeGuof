package com.guof.sum_numbers;


class Solution {
    int output;

    public int sumNumbers(TreeNode root) {
        output = 0;
        dfs(root, new StringBuilder());
        return output;
    }

    public void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            // 入土了
            return;
        }

        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            // 是叶子节点
            output += Integer.parseInt(stringBuilder.toString());
        }
        dfs(root.left, stringBuilder);
        dfs(root.right, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
    }
}