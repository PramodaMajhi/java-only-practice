package com.arrays.string.chapter1;

import javafx.beans.binding.StringBinding;

/**
 * Insert all the words one by one in the trie, after inserting we perform walk on the trie
 * In this walk, we will go deeper until we found a
 * node having more than 1 children(branching occurs) or 0 children(one of the string get exhausted)
 * This is because the characters(node in the trie) which present in the longest common
 * prefix must be the single child of its parent i.e - there should not be branching
 * in any of these nodes.
 *
 * Time Complexity : Inserting all the words in the trie takes O(MN) time and performing a walk on the trie takes O(M) time, where-
 *
 * N = Number of strings
 * M = Length of the largest string
 * Auxiliary Space: To store all the strings we need to allocate O(26*M*N) ~ O(MN) space for the Trie.
 */
public class Trie {
    private static final int ALPHABET_SIZE=26;
    private Node root;
    public  Trie() {
       root = new Node('\0');
    }

    private static class Node {
        private char c;
        private boolean isWord;
        private Node[] children ;
        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[ALPHABET_SIZE];
        }
    }
    public void insert(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char newch = word.charAt(i);
            if(current.children[newch - 'a'] == null) {
                current.children[newch-'a'] = new Node(newch);
            }
            current = current.children[newch - 'a']; // moving down the tree;
        }
        current.isWord = true;
    }
    public String longestCommonPrefix(String words[]) {
        if(words == null || words.length == 0) return "";
        if(words.length == 1) return words[0];
        for (int i = 1; i < words.length; i++) {
            insert(words[i]);
        }
        String s = searchLongestPrefix(words[0]);
        // System.out.println(s);
        return s;
    }
    // Counts and returns the number of children of the
    // current node
    int indexs;
    public int countChildren(Node node)
    {
        int count = 0;
        for (int i=0; i<ALPHABET_SIZE; i++)
        {
            if (node.children[i] != null)
            {
                count++;
                indexs = i;
            }
        }
        return (count);
    }
    private String searchLongestPrefix(String word) {
        Node current = root;
        StringBuilder prefix = new StringBuilder();
        // if count more than 1 that means branching started, hence ending the loop
        while (countChildren(current) == 1 && !current.isWord) {

            current = current.children[indexs];
            char ch = (char)('a'+indexs);
            prefix.append(ch);
        }
        return prefix.toString();
    }
    public  boolean search(String word) {
        Node node  = getNode(word);
        return node != null && node.isWord;
    }
    public  boolean startsWith(String prefix) {
        Node node  = getNode(prefix);
        return node != null; // prefix exist
    }

    private   Node getNode (String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) return null; // Node at character is not created
            current = current.children[c - 'a'];
        }
        return  current; // this is the very last character inside that character
    }
    public static void main(String[] args) {
        Trie t = new Trie();
      //  String arr[]  = {"flower", "flight", "flow"};
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
       String lcp =  t.longestCommonPrefix(arr);
        System.out.println(lcp);
        System.out.println(t.search("geek"));
        System.out.println(t.startsWith("geeksforgeeks"));
    }

}
