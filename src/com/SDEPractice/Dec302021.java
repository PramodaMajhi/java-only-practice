package com.SDEPractice;

import com.arrays.string.chapter1.Hash;

import java.util.*;

public class Dec302021 {


    /*
    863. All Nodes Distance K in Binary Tree
    Given the root of a binary tree, the value of a target node target,
    and an integer k, return an array of the values of all nodes that
    have a distance k from the target node.
    You can return the answer in any order.
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
    Output: [7,4,1]
    Explanation: The nodes that are a distance 2 from the target node
    (with value 5) have values 7, 4, and 1
     */

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x;
         }
     }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceKNice(TreeNode root, TreeNode target, int k) {
        dis(root, target, k);

        return result;
    }

    // Returns the distance from root to target.
    // Returns -1 if target does not in the tree.
    private int dis(TreeNode root, TreeNode target, int k) {
        if (root == null) return -1;
        if (root == target) {
            collect(root, k);
            return 0;
        }

        int l = dis(root.left, target, k);
        int r = dis(root.right, target, k);

        // target in left tree
        if (l >= 0) {
            if (l == k - 1) result.add(root.val);
            collect(root.right, k - l - 2);
            return l + 1;
        }

        // target in right tree
        if (r >= 0) {
            if (r == k - 1) result.add(root.val);
            collect(root.left, k - r - 2);
            return r + 1;
        }

        return -1;
    }

    // Collect nodes that are d steps from root.
    private void collect(TreeNode root, int d) {
        if (root == null || d < 0) return;
        if (d == 0) result.add(root.val);
        collect(root.left, d - 1);
        collect(root.right, d - 1);
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         List<Integer> res = new ArrayList<Integer>();
         if(root == null) return  res;
         HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
         findParent(parentMap, root);
         Queue<TreeNode> queue  = new LinkedList<>();
         HashSet<TreeNode> visited = new HashSet<TreeNode>();

         // add the target node into the queue

        queue.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current  = queue.poll();
                visited.add(current);

                if(k == 0) {
                    res.add(current.val);
                }
                if(parentMap.containsKey(current) && !visited.contains(parentMap.get(current))){
                    queue.add(parentMap.get(current));
                }
                if(current.left!=null && !visited.contains(current.left)) {
                    queue.add(current.left);
                }
                if(current.right!=null && !visited.contains(current.right)) {
                    queue.add(current.right);
                }
            }
            k--;
            if(k < 0) break;
        }
        return res;
    }

    private static void findParent(HashMap<TreeNode, TreeNode> map, TreeNode root) {
         if(root == null) return;
         if(root.left!=null) {
            map.put(root.left, root);
         }
         if(root.right!=null) {
             map.put(root.right, root);
         }
         findParent(map, root.left);
         findParent(map, root.right);
         return;
    }

    public static double average(int[] salary) {
        double sum = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = salary.length;
        for(int sal: salary) {
            sum+=sal;
            min = Math.min(min,sal);
            max = Math.max(max, sal);
        }

        return (sum - min - max)/ (n -2);
    }
    public static double average1(int[] salary) {
        Arrays.sort(salary);
        int min = salary[0];
        int max = salary[salary.length - 1];
        int sum = 0;
        for(int i = 0; i < salary.length; i++){
            sum += salary[i];
        }
        double newSum = sum - min - max;
        double newLength = salary.length - 2;
        double avg = newSum / newLength;
        return avg;
    }
}
