package com.completedsa.dsa.trie;
import java.util.HashMap;
import java.util.Map;

public class TrieImplByMap {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String key) {
            if (key == null || key.isEmpty()) {
                return;
            }

            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isEndOfWord = true;
        }

        // Search for an exact word
        public boolean search(String key) {
            if (key == null || key.isEmpty()) {
                return false;
            }

            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return curr.isEndOfWord;
        }

        // Check if a prefix exists in the Trie
        public boolean isPrefix(String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return false;
            }

            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return true;
        }

        // Delete a word (optional)
        public boolean delete(String key) {
            return deleteHelper(root, key, 0);
        }

        private boolean deleteHelper(TrieNode node, String key, int index) {
            if (index == key.length()) {
                if (!node.isEndOfWord) {
                    return false; // word not found
                }
                node.isEndOfWord = false;
                return node.children.isEmpty();
            }

            char c = key.charAt(index);
            TrieNode child = node.children.get(c);
            if (child == null) return false;

            boolean shouldDeleteChild = deleteHelper(child, key, index + 1);
            if (shouldDeleteChild) {
                node.children.remove(c);
                return node.children.isEmpty() && !node.isEndOfWord;
            }
            return false;
        }

        // Print all words (for debug)
        public void printAllWords() {
            printAllWordsHelper(root, new StringBuilder());
        }

        private void printAllWordsHelper(TrieNode node, StringBuilder prefix) {
            if (node.isEndOfWord) {
                System.out.println(prefix.toString());
            }

            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                prefix.append(entry.getKey());
                printAllWordsHelper(entry.getValue(), prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

        public static void main(String[] args) {
            Trie trie = new Trie();

            trie.insert("do");
            trie.insert("Dad");
            trie.insert("Đỏ");
            trie.insert("Dấu cách");
            trie.insert("123");
            trie.insert("email@domain.com");
            trie.insert("#smile");

            System.out.println(trie.search("do"));            // true
            System.out.println(trie.search("dad"));           // false (case-sensitive)
            System.out.println(trie.search("Dad"));           // true
            System.out.println(trie.search("Đỏ"));            // true
            System.out.println(trie.search("email@domain.com")); // true
            System.out.println(trie.isPrefix("ema"));         // true

            System.out.println("\nAll words in Trie:");
            trie.printAllWords();

            System.out.println("\nDelete 'Dad': " + trie.delete("Dad"));
            System.out.println("Search 'Dad': " + trie.search("Dad"));
        }
    }

}
