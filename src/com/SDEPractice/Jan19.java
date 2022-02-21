package com.SDEPractice;

import java.util.*;

public class Jan19 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
       String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(removeSubfolders(folder));
    }

    static class TrieNode
    {
        int folEnd=0;
        String data;
        Map<String, TrieNode> children = new HashMap<>();
        public TrieNode()
        {
            data = "";
        }
        public TrieNode(String c)
        {
            data= c;
        }
        public void insertString(TrieNode root, String s[])
        {
            TrieNode curr = root;
            for(String str : s)
            {
                if(str.length()==0) continue;

                if(!curr.children.containsKey(str))
                    curr.children.put(str, new TrieNode(str));

                curr = curr.children.get(str);
            }
            curr.folEnd++;
        }
        public void dfs(TrieNode root, StringBuilder curr, List<String> res)
        {
            //curr.append("/"); curr.append(data);

            if(root.folEnd>0)
            {
                res.add(curr.toString());
                return;
            }

            curr.append('/');
            for(String k : root.children.keySet())
            {
                StringBuilder new_curr = new StringBuilder(curr);
                new_curr.append(k);
                dfs(root.children.get(k),new_curr, res);

            }
        }

    }
    public List<String> removeSubfolders1(String[] folder) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String s: folder)
        {
            String f[] = s.split("/");
            root.insertString(root, f);
            System.out.println(Arrays.toString(f));
        }
        root.dfs(root, new StringBuilder(), res);
        return res;
    }

    /*
    IDEA:
    Sort folder by length;
    Check if the folder's parent fold in HashSet before adding it into the HashSet.
        Note: the part before any / is a parent.
    Second IDEA: Without hashSet this can be implemented,
    we just need to check the last element in the list does not start with current one
    Using existing startWith() and appending "/" to the end

    IDEA2: Trie Implementation

    */

    /*
    Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
    Output: ["/a","/c/d","/c/f"]
    Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
     */
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        //HashSet<String> set = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String fl  = folder[i];
            if (!fl.startsWith(list.get(list.size() - 1) + "/")) {
                list.add(folder[i]);
            }
        }

        return list;
    }
    /*
         590. N-ary Tree Postorder Traversal
        IDEA: Typical DFS problem.
        This is a post order traversal, we need to keep in mind the post order
        left -> right -> root
        The only trick is here, we need take care of list of nodes
        we need to run a for loop to travers and and the function call
        don't forget to list.add(roo.val)
        Note: Don't forget to implement using iterative
        Time and Space: O(n)

     */
    public List<Integer> postorder(Node root) {
        return helper(root, new ArrayList<Integer>());
    }


    public List<Integer>helper(Node x, List<Integer> list) {
        if(x == null)  return list;
        for(Node item : x.children) {
            list = helper(item, list);
        }
        list.add(x.val);
        return list;
    }


}
