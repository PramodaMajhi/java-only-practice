package com.structy.binaryTree;

import javax.sound.midi.Soundbank;

public class HowHigh {

    public int howHigh(Node root){
        if(root == null) return  -1;

        return 1 + Math.max(howHigh(root.left), howHigh(root.right));
    }

    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

//      a
//    /   \
//   b     c
//  / \     \
// d   e     f

       // howHigh(a); // -> 2
        HowHigh howHigh = new HowHigh();
        System.out.println(howHigh.howHigh(a));
    }
}
