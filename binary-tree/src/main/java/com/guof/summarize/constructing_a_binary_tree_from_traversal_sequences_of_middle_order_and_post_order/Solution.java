package com.guof.summarize.constructing_a_binary_tree_from_traversal_sequences_of_middle_order_and_post_order;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ArrayList<Integer> inorderArrayList = new ArrayList<>();
        ArrayList<Integer> postorderArrayList = new ArrayList<>();

        for (int i : inorder) {
            inorderArrayList.add(i);
        }
        for (int i : postorder) {
            postorderArrayList.add(i);
        }

        return dfs(inorderArrayList, postorderArrayList);
    }


    public TreeNode dfs(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.isEmpty()) return null;

        TreeNode curRoot = new TreeNode();
        curRoot.val = postorder.get(postorder.size() - 1);
        postorder.remove(postorder.size() - 1);
        for (int i = 0; i < inorder.size(); i++) {
            if (curRoot.val == inorder.get(i)) {
                // i+1到最右边是右侧子树
                // [0,i-1]是左侧子树
                curRoot.right = dfs(inorder.subList(i + 1, inorder.size()), postorder);
                curRoot.left = dfs(inorder.subList(0, i), postorder);
            }

        }

        return curRoot;
    }
}