package com.guof.summarize.constructing_a_binary_tree_from_traversal_sequences_of_pre_order_and_middle_order;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 和后序一样的，顺序反了一下
        Queue<Integer> preorderQueue = new LinkedList<>();

        for (int i : preorder) {
            preorderQueue.add(i);
        }

        return dfs(inorder, 0, inorder.length, preorderQueue);
    }


    public TreeNode dfs(int[] inorder, int inorderBegin, int inorderEnd, Queue<Integer> preorder) {
        if (inorderBegin >= inorderEnd) return null;

        TreeNode curRoot = new TreeNode();
        curRoot.val = preorder.poll();
        for (int i = inorderBegin; i < inorderEnd; i++) {
            if (curRoot.val == inorder[i]) {
                // i+1到最右边是右侧子树
                // [0,i-1]是左侧子树
                curRoot.left = dfs(inorder, inorderBegin, i, preorder);
                curRoot.right = dfs(inorder, i + 1, inorderEnd, preorder);
                break;
            }
        }
        return curRoot;
    }
}