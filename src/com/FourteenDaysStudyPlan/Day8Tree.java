package com.FourteenDaysStudyPlan;


import java.util.LinkedList;
import java.util.Queue;

public class Day8Tree {

    private static class TreeNode {
        private int val;
        private TreeNode left, right,next;
        private TreeNode() {

        }
        private TreeNode(int val) {
            this.val = val;
        }
        private TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
/*
        116. Populating Next Right Pointers in Each Node
        Input: root = [1,2,3,4,5,6,7]
        Output: [1,#,2,3,#,4,5,6,7,#]
 */
/*
    Time Complexity: O(n) Since we process each node exactly once,
    Note: The processing of node from queue and then establish the next pointers

    Space Complexity: O(n) This is a perfect binary tree which means the last level n/2
    node.
    the space complexity for BFS is the space occupied by the queue which is dependent upon
    the maximum number of nodes in particular level so in this case space complexity is O(N)
 */
    public TreeNode connect(TreeNode root) {

        if(root == null) return root;

        // Initialize the Queue data structure which contains just root of the tree
        Queue<TreeNode>  queue = new LinkedList<TreeNode>();
        queue.add(root);
        // Outer loop which iterates over each level
        while (queue.size() > 0) {
            // We should not override size
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node  = queue.poll();
                if(i < size -1) {
                    node.next = queue.peek();
                }
                // add the children, if any back of the queue
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
        }
        return root;

    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null) return  root2;
        if(root2 == null) return  root1;

        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return  root1;
    }
}
