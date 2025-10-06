package com.completedsa.dsa.trie;

/**
 * The Trie data structure is used to store a set of keys represented as strings.
 * Each node represents a character or a part of a string.
 * The root node acts as a starting point and does not store any character.
 */
public class TrieImplByArray {
    // Time Complexity
    // Insertion: O(n), where n is the length of the string inserted
    // Searching: O(n)
    // Prefix Searching: O(n)
    // Deletion: O(n)

    static int ALPHABET_SIZE = 26; // char from 'a' to 'z'

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Method to insert a key into the Trie

        /**
         * root
         *  └── 'a'
         *       └── 'n' (isEndOfWord = true) -> word: an
         *            └── 'd' (isEndOfWord = true) -> word: and
         */
        public void insert(String key) {
            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }

            curr.isEndOfWord = true;
        }

        // Method to search a key in the Trie
        public boolean search(String key) {
            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }

            return curr.isEndOfWord;
        }

        // Method to check if a prefix exists in the Trie
        public boolean isPrefix(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }

            return true;
        }

        // Returns true if root has no children, else false
        public boolean isEmpty(TrieNode root) {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (root.children[i] != null) {
                    return false;
                }
            }

            return true;
        }

        public TrieNode remove(TrieNode root, String key, int depth) {
            // If tree is empty
            if (root == null) {
                return null;
            }

            // If last character of key is being processed
            if (depth == key.length()) {
                // This node is no more end of word after removal of given key
                if (root.isEndOfWord) {
                    root.isEndOfWord = false;
                }

                // If given is not prefix of any other word
                if (isEmpty(root)) {
                    root = null;
                }

                return root;
            }

            // If not last character, recur for the child obtained
            int index = key.charAt(depth) - 'a';
            root.children[index] = remove(root.children[index], key, depth + 1);

            // If root does not have any child (its only child got deleted), and it is not end of another word.
            if (isEmpty(root) && !root.isEndOfWord) {
                root = null;
            }

            return root;
        }

        public static void main(String[] args) {
            Trie trie = new Trie();
            String[] arr = {"and", "ant", "do", "dad", "hero", "heroplane"};
            for (String s : arr) {
                trie.insert(s);
            }

            String[] searchKeys = { "do", "gee", "bat" };
            for (String s : searchKeys) {
                if (trie.search(s))
                    System.out.print("true ");
                else
                    System.out.print("false ");
            }
            System.out.println();

            String[] prefixKeys = { "ge", "ba", "do", "de" };
            for (String s : prefixKeys) {
                if (trie.isPrefix(s))
                    System.out.print("true ");
                else
                    System.out.print("false ");
            }
            System.out.println();

            trie.remove(trie.root, "heroplane", 0);

            if(trie.search("hero"))
                System.out.println("Yes");
            else
                System.out.println("No");

            if(trie.search("heroplane"))
                System.out.println("Yes");
            else
                System.out.println("No");

        }
    }
}
