package com.feng.tree_and_graph.constructing_binary_tree_from_pre_order_and_middle_order_traversal_sequences;

/**
 * ClassName: Solution
 * Package: com.feng.tree_and_graph.constructing_binary_tree_from_pre_order_and_middle_order_traversal_sequences
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 19:52
 * @Version 1.0
 */
//class Solution {
//    int[] preorder;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.preorder = preorder;
//        return build(inorder);
//    }
//
//    public TreeNode build(int[] inorder) {
//        if (inorder.length == 0)
//            return null;
//        int rootVal = preorder[0];
//        preorder = Arrays.copyOfRange(preorder, 1, preorder.length); // 手动删掉第一个值
//        TreeNode root = new TreeNode(rootVal);
//
//        // 找到inorder里和preorder第一个数字相同的数字
//        int idx = 0;
//        for (; idx < inorder.length; idx++) {
//            if (inorder[idx] == rootVal) {
//                break;
//            }
//        }
//        if (idx == inorder.length) {
//            idx = -1;
//        }
//
//
//        if (idx == -1) {
//            root.left = null;
//        } else {
//            root.left = build(Arrays.copyOfRange(inorder, 0, idx));
//        }
//
//        root.right = build(Arrays.copyOfRange(inorder, idx + 1, inorder.length));
//
//
//        return root;
//    }
//}

class Solution {
    int preorderCurIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderCurIdx = 0;
        return dfs(inorder, 0, inorder.length, preorder);
    }

    public TreeNode dfs(int[] inorder, int inorderBegin, int inorderEnd, int[] preorder) {
        if (inorderBegin >= inorderEnd || preorderCurIdx >= preorder.length) {
            return null;
        }
        int curRootValue = preorder[preorderCurIdx];
        preorderCurIdx++;
        TreeNode curNode = new TreeNode(curRootValue);

        for (int i = inorderBegin; i < inorderEnd; i++) {
            if (inorder[i] == curRootValue) {
                curNode.left = dfs(inorder, inorderBegin, i, preorder);
                curNode.right = dfs(inorder, i + 1, inorderEnd, preorder);
                break;
            }
        }
        return curNode;
    }

}