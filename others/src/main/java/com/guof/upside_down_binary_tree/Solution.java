package com.guof.upside_down_binary_tree;


import java.util.*;

class Solution {
    Queue<TreeNode> queue;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // 左、右、头这不是后序遍历吗？看我秒杀，嘻嘻
        queue = new LinkedList<>();
        dfs(root);
        queue.add(root);
        TreeNode head = queue.poll();
        TreeNode moveNode = head;
        if (moveNode == null) {
            return null;
        }
        while (!queue.isEmpty()) {
            moveNode.left = queue.poll();
            moveNode.right = queue.poll();
            moveNode = moveNode.right;
        }
        moveNode.left = null;
        moveNode.right = null;
        return head;
    }


    public void dfs(TreeNode root) {
        // 本来应该是直接保存root的，现在改为保存root的左右节点
        // 左节点非空，右节点为空的情况下，要把右节点的null也加入到queue里。
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        dfs(root.left);
        dfs(root.right);
        queue.add(root.left);
        queue.add(root.right);
    }
}