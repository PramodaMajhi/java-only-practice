package com.SDEPractice;

import java.util.*;

public class Dec22BalanceBST {

    private static class TreeNode {
        private int data;
        private TreeNode left, right;
        TreeNode(int data) {
            this.data  = data;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data  = data;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode insertBST(TreeNode root, int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }
        if(root.data < data) {
            root.right = insertBST(root.right, data);
        } else if(root.data > data){
            root.left = insertBST(root.left, data);
        } else return root;
        return  root;
    }
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>(Arrays.asList(1,2,3,4));
        TreeNode root = null;
        for (Integer data: list) {
            root = insertBST(root, list.get(data));
        }
        List<Integer> orderList = new ArrayList<>();
        inOrderTraversal(root, orderList);

        int low = 0;
        int high = orderList.size()-1;
        perfectBalace(orderList, low, high);


    }
    public static  TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        return  root;
    }
    private static void inOrderTraversal(TreeNode root, List<Integer> orderList) {

        if(root == null) return;
        inOrderTraversal(root.left, orderList);
        orderList.add(root.data);
        inOrderTraversal(root.right, orderList);
    }
    public static TreeNode perfectBalace(List<Integer> list, int low, int high) {

            if(high < low) {
            return null;
        }

        int mid  = low + (high -low/2);
        TreeNode root = null;
        root = insertBST(root, list.get(mid));
        root.left = perfectBalace(list, low, mid-1);
        root.right = perfectBalace(list, mid+1, high);
        return  root;
    }
}
