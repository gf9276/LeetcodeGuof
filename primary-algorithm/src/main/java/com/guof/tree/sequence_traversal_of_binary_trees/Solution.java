package com.guof.tree.sequence_traversal_of_binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Solution
 * Package: com.feng.tree.sequence_traversal_of_binary_trees
 * Description:
 *
 * @Author guof
 * @Create 2023/3/26 22:38
 * @Version 1.0
 */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            // 感觉搞个队列？确实，BFS

            if (root == null) {
                return new ArrayList<>(); // 返回空数组
            }

            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                int level_nbr = queue.size();
                List<Integer> subList = new ArrayList<>();

                int i;
                for (i = 0; i < level_nbr; i++) {
                    TreeNode node = queue.poll(); // 弹出
                    subList.add(node.val); // 加入节点

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }

                }
                res.add(subList);
            }
            return res;
        }
    }