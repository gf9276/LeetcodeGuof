package com.guof.replace_valueIn_tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        // 层序遍历，显然的
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        root.val = 0; // root没有堂兄弟
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<List<TreeNode>> tmpList1 = new ArrayList<>(); // 存节点
            int curStoreySum = 0; // 同一层所有数值的和
            for (int i = 0; i < size; i++) {
                // 这里面的都是同一层的
                TreeNode curNode = queue.poll();
                List<TreeNode> tmp1 = new ArrayList<>();
                assert curNode != null;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                    tmp1.add(curNode.left);
                    curStoreySum += curNode.left.val;
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                    tmp1.add(curNode.right);
                    curStoreySum += curNode.right.val;
                }
                tmpList1.add(tmp1);
            }
            // 更新节点的值
            for (List<TreeNode> treeNodes : tmpList1) {
                int curListSum = 0;
                for (TreeNode treeNode : treeNodes) {
                    curListSum += treeNode.val;
                }
                for (TreeNode treeNode : treeNodes) {
                    treeNode.val = curStoreySum - curListSum;
                }
            }
        }
        return root;
    }
}