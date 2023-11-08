package com.guof.vertical_order;


import java.util.*;

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // 好像，真是太像了，中序遍历，左头右
        // 算了，还是层序遍历吧，节点应该不会重复，那搞个map就好了
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Map<Integer, List<Integer>> map1 = new HashMap<>(); // 用来记录这一列有哪些内容
        Map<TreeNode, Integer> map2 = new HashMap<>(); // 用来记录当前点是哪一列的

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map2.put(root, 0);
        map1.put(0, new ArrayList<>(List.of(root.val)));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                int curRow = map2.get(curNode);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                    int tmpRow = curRow - 1;
                    map2.put(curNode.left, tmpRow);
                    List<Integer> tmpList = map1.getOrDefault(tmpRow, new ArrayList<>());
                    tmpList.add(curNode.left.val);
                    map1.put(tmpRow, tmpList);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                    int tmpRow = curRow + 1;
                    map2.put(curNode.right, tmpRow);
                    List<Integer> tmpList = map1.getOrDefault(tmpRow, new ArrayList<>());
                    tmpList.add(curNode.right.val);
                    map1.put(tmpRow, tmpList);
                }
            }
        }

        List<Integer> tmpList = new ArrayList<>(map1.keySet());
        Collections.sort(tmpList);

        for (Integer integer : tmpList) {
            output.add(map1.get(integer));
        }
        return output;
    }
}