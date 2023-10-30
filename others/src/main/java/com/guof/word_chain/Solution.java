package com.guof.word_chain;


import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 以前都是用dfs，这次试试bfs？
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordList.remove(beginWord);

        int height = 0; // 统计层数
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();
                if (curStr.equals(endWord)) {
                    return height + 1;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (oneDist(curStr, wordList.get(j))) {
                        queue.add(wordList.get(j));
                        wordList.remove(j);
                        j--;
                    }
                }
            }
            height++;
        }
        return 0;
    }

    public boolean oneDist(String a, String b) {
        int output = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                output++;
            }
            if (output > 1) {
                return false;
            }
        }
        return output == 1;
    }
}