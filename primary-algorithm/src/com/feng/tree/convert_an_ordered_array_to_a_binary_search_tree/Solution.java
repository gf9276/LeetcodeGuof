package com.feng.tree.convert_an_ordered_array_to_a_binary_search_tree;

/**
 * ClassName: Solution
 * Package: com.feng.tree.convert_an_ordered_array_to_a_binary_search_tree
 * Description:
 *
 * @Author guof
 * @Create 2023/3/26 22:48
 * @Version 1.0
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            // 长度为0，不用管
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1); // 开始迭代

    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2; // 获取中间节点

        TreeNode root = new TreeNode(num[mid]); // 以中间值为节点

        root.left = sortedArrayToBST(num, start, mid - 1); // 对应情况 start > end
        root.right = sortedArrayToBST(num, mid + 1, end); // 对应情况 start > end

        return root;

    }
}