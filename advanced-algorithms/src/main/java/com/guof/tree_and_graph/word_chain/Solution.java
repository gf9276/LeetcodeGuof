package com.guof.tree_and_graph.word_chain;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // bfs扩散
        wordList.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // 写着写着变成bfs了。。。
        int curDeep = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String curWord = queue.poll();
                // 遍历所有未遍历过的点，找到相邻值为1的点
                for (int j = 0; j < wordList.size(); j++) {
                    if (oneDiff(curWord.toCharArray(), wordList.get(j).toCharArray())) {
                        if (wordList.get(j).equals(endWord)) {
                            return curDeep + 1;
                        }
                        queue.add(wordList.get(j));
                        wordList.remove(j--);
                    }
                }

            }
            curDeep++;
        }
        return 0;
    }

    public boolean oneDiff(char[] c1, char[] c2) {
        int diffNbr = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                diffNbr++;
            }
            if (diffNbr > 1) {
                return false;
            }
        }
        return diffNbr == 1;
    }
}