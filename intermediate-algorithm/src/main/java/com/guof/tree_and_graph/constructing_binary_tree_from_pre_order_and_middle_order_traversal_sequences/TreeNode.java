package com.guof.tree_and_graph.constructing_binary_tree_from_pre_order_and_middle_order_traversal_sequences;

/**
 * ClassName: TreeNode
 * Package: com.feng.tree_and_graph.constructing_binary_tree_from_pre_order_and_middle_order_traversal_sequences
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 19:58
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