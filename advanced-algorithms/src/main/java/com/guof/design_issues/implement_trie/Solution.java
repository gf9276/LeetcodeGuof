package com.guof.design_issues.implement_trie;

class Trie {
    class TrieNode {
        boolean end; // 到此为止，是否插入了该完整单词
        TrieNode[] tns = new TrieNode[26]; // 树枝，26个分叉
    }

    TrieNode root; // 根节点

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p.tns[word.charAt(i) - 'a'] == null) {
                p.tns[word.charAt(i) - 'a'] = new TrieNode();
            }
            p = p.tns[word.charAt(i) - 'a'];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p.tns[word.charAt(i) - 'a'] != null) {
                p = p.tns[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (p.tns[prefix.charAt(i) - 'a'] != null) {
                p = p.tns[prefix.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}