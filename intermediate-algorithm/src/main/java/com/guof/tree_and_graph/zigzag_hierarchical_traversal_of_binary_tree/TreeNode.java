package com.guof.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree;

/**
 * ClassName: TreeNode
 * Package: com.feng.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 17:29
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
