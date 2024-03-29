package com.guof.tree.convert_an_ordered_array_to_a_binary_search_tree;

/**
 * ClassName: TreeNode
 * Package: com.feng.tree.maximum_depth_of_a_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 21:56
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}