package com.completedsa.dsa.trie;
import java.util.HashMap;
import java.util.Map;

/**
 * A Trie (also known as a Prefix Tree) is a tree-based data structure that is used to store a dynamic set of strings, where the keys are usually strings.
 */
public class TrieImplByMap {
    // Each node in the Trie represents a single character of a word
    static class TrieNode {
        // Each node contains a map to store child nodes
        Map<Character, TrieNode> children;
        // A boolean value to mark if the node represents the end of a word
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

        // Insert a word into the trie
        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(c, key -> new TrieNode());
            }
            curr.isEndOfWord = true;
        }

        // Searches for a word in the Trie
        public boolean search(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.children.get(c);
                if (curr == null) {
                    return false;
                }
            }

            return curr.isEndOfWord;
        }

        // Checks if there exists any word in the Trie that starts with the given prefix
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                curr = curr.children.get(c);
                if (curr == null) {
                    return false;
                }
            }

            return true;
        }

        // Deletes a word from the Trie.
        public void  delete(String word) {
            deleteHelper(root, word, 0);
        }

        private boolean deleteHelper(TrieNode node, String word, int index) {
            if (index == word.length()) {
                if (!node.isEndOfWord) {
                    return false; // word not found
                }
                node.isEndOfWord = false;
                return node.children.isEmpty(); // if no children, it can be deleted
            }

            char ch = word.charAt(index);
            TrieNode childNode = node.children.get(ch);
            if (childNode == null) {
                return false; // word not found
            }

            boolean shouldDeletedChild = deleteHelper(childNode, word, index + 1);
            if (shouldDeletedChild) {
                node.children.remove(ch);
                return node.children.isEmpty() && !node.isEndOfWord; // If current node has no other children and is not end of another word, delete it
            }

            return false;
        }

        // Print all words
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

            // Insert words
            trie.insert("apple");
            trie.insert("app");
            trie.insert("bat");
            trie.insert("batman");

            // Search words
            System.out.println(trie.search("apple"));  // true
            System.out.println(trie.search("app"));    // true
            System.out.println(trie.search("bat"));    // true
            System.out.println(trie.search("bats"));   // false

            // Prefix search
            System.out.println(trie.startsWith("ba")); // true
            System.out.println(trie.startsWith("cat")); // false

            // Delete words
            trie.delete("batman");
            System.out.println("Search 'batman': " + trie.search("batman")); // false
            System.out.println("Search 'bat': " + trie.search("bat"));    // true

            System.out.println("\nAll words in Trie:");
            trie.printAllWords();

            trie.delete("bat");
            System.out.println("Search 'bat': " + trie.search("bat")); // false
        }
    }

}
