package com.feng.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree;

import java.util.*;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 17:28
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.zigzag_hierarchical_traversal_of_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 17:28
 * @Version 1.0
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        // BFS遍历直接用队列就行，先压进去，然后拉出来
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> a_list = new ArrayList<>();
        int now_plies = 0;

        queue.add(root);
        while (true) {
            TreeNode node = queue.poll(); // 拉出来
            a_list.add(node.val);

            if (now_plies % 2 == 0) {
                // 偶数行，先左再右，从 0 开始的
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            } else {
                // 奇数行先右再左，从 0 开始的
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            if (queue.isEmpty()) {
                now_plies++;
                output.add(new ArrayList<>(a_list));
                a_list.clear();
                if (stack.isEmpty()) {
                    break;
                } else {
                    while (!stack.isEmpty()) {
                        queue.add(stack.pop());
                    }
                }
            }
        }

        return output;
    }
}
