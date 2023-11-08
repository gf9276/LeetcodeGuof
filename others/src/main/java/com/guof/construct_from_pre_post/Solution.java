package com.guof.construct_from_pre_post;


import java.util.Arrays;

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0) {
            // 前序遍历没有了
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]); // 该节点为根节点
        if (preorder.length == 1) {
            return root;
        }

        // 右边第一个是左节点，左节点后面 n 个是左子树节点。只能这样假设了
        // 去后序遍历找，后序遍历 左节点 的子节点，在他左边

        int n = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (preorder[1] == postorder[i]) {
                n = i + 1; // 左边i个是左节点的子节点
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, n + 1), Arrays.copyOfRange(postorder, 0, n));
        root.right = constructFromPrePost(Arrays.copyOfRange(preorder, n + 1, preorder.length), Arrays.copyOfRange(postorder, n, preorder.length - 1));

        return root;
    }
}