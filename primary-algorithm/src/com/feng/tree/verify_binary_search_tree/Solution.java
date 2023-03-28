package com.feng.tree.verify_binary_search_tree;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

/**
 * ClassName: Solution
 * Package: com.feng.tree.maximum_depth_of_a_binary_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 21:58
 * @Version 1.0
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBST(root.left, min, root.val) & isValidBST(root.right, root.val, max);
    }
}