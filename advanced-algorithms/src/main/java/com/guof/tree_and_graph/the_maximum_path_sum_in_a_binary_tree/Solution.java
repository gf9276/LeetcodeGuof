package com.guof.tree_and_graph.the_maximum_path_sum_in_a_binary_tree;


import java.util.Arrays;

class Solution {
    int output;


    public int maxPathSum(TreeNode root) {
        // 不就是节点到节点的距离吗，这有什么难的？
        output = Integer.MIN_VALUE;
        dfs(root);
        return output;
    }

    public int dfs(TreeNode root) {
        // 如何判断是终点呢？
        if (root == null) {
            return 0;
        }

        // 处处是节点
        int left = dfs(root.left);
        int right = dfs(root.right);

        int max = Math.max(left, right);

        int[] tmpArr = new int[]{output, root.val, root.val + max, root.val + left + right};
        output = Arrays.stream(tmpArr).max().getAsInt();

        return Math.max(root.val, root.val + max);
    }
}