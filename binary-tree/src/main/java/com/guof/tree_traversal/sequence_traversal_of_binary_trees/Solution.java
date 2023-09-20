package com.guof.tree_traversal.sequence_traversal_of_binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    List<List<Integer>> output;

    public List<List<Integer>> levelOrder(TreeNode root) {
        output = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) continue;

                curList.add(curNode.val);
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
            if (!curList.isEmpty()) {
                output.add(curList);
            }

        }

        return output;
    }

}