package com.arrays.practiceproblem;

import java.util.ArrayList;

public class TrieRecursive {
    public  static  int R_WAY = 26;
    public Node root;
    public int n ;

    private static  class Node {
        private boolean isWord;
        private Node children[] = new Node[R_WAY];
    }

   public TrieRecursive() {

    }

    public void put(String word) {
        if(word == null && word.length() == 0){
           throw new IllegalArgumentException("Key should not be null to put()");
        }else {
            root = put(root, word, 0);
        }
    }

    private Node put(Node x, String word, int d) {
        if(x == null) {
           x =  new Node();
        }
        if(d == word.length()) {
            if(!x.isWord) {
                n++;
                x.isWord = true;
                return x;
            }
        }
        char c  = word.charAt(d);
        x.children[c -'a'] = put(x.children[c-'a'], word,d+1);
        return x;
    }

    public boolean get(String word) {
        if(word == null && word.length() == 0)
            throw new IllegalArgumentException("Argument to get() is null");
            Node x  = get(root, word, 0);
            if(x == null) return  false;
            return x.isWord;
    }

    public Node get(Node x, String word, int d) {
        if(x == null) return null;
        if(d == word.length())
            return  x;
        char c = word.charAt(d);
        return get(x.children[c - 'a'], word, d+1);
    }

    public int siz() {
        return n;
    }

    public boolean isEmpty() {
        return  siz() == 0;
    }

    public boolean contains(String word) {
        if(word == null && word.length() == 0)
            throw  new IllegalArgumentException("Argument to contains() is null");
       return !get(word);
    }


    public ArrayList<String> getKeyWithPrefix(String prefix) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Node x = get(root,prefix, 0);
        collect(x, new StringBuilder(prefix), arrayList);
        return arrayList;
    }

    public void collect(Node x , StringBuilder prefix , ArrayList<String> alist) {

        if(x == null)
            return;
        if(x.isWord) {
            alist.add(prefix.toString());
        }

//        for (char c = 'a'; c <= 'z' ; c++) {
//            prefix.append(c);
//            collect(x.children[c - 'a'], prefix, alist );
//            prefix.deleteCharAt(prefix.length() - 1);
//        }

        for (int i = 0; i < R_WAY ; i++) {
            char ch = (char)('a'+i);
            prefix.append(ch);
            collect(x.children[ch - 'a'], prefix, alist );
            prefix.deleteCharAt(prefix.length() - 1);
        }

    }

    public void delete() {

    }

    public static void main(String[] args) {
        TrieRecursive trie = new TrieRecursive();
        trie.put("abc");
        trie.put("apple");
        trie.put("banana");
//      boolean a =  trie.get("a");
//      System.out.println(a);
        ArrayList<String> prefixList = trie.getKeyWithPrefix("a");
        for(String w : prefixList) {
            System.out.println(w);
        }
    }

}
