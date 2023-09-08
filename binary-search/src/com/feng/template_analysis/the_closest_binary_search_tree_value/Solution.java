package com.feng.template_analysis.the_closest_binary_search_tree_value;


class Solution {
    public int closestValue(TreeNode root, double target) {
        // 二叉搜索树是有顺序的

        int output = root.val;

        while (root != null) {
            if (Math.abs(target - root.val) == Math.abs(target - output)) {
                output = Math.min(output, root.val);
            } else if (Math.abs(target - root.val) < Math.abs(target - output)) {
                output = root.val;
            }

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return output;
    }
}