import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * This is binary search tree, This is a DFS traversal
 */
public class PrintLeafNodes {
    Node root;

    private static class Node {
        private int data;
        private Node left;
        private Node right;
        

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            root.data = data;
            return root;
        }
        if (root.data < data) {
            root.right = insertNode(root.right, data);
        } else if(root.data > data){
            root.left  = insertNode(root.left, data);
        } else {
            return root;
        }
        return root;
    }

    public static void printLeaves(Node root) {
        if (root == null)
            return;
        // check if a given node is a leaf
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ,");
            return;
        }
        if (root.left != null) {
            printLeaves(root.left);
        }
        if (root.right != null) {
            printLeaves(root.right);
        }
    }

    public static void main(String args[]) {
        List<Integer> dataInput = List.of(100, 80, 50, 90, 30, 60, 90, 85, 95, 120, 110, 108, 115, 140, 150);
        Node root = null;
        for (Integer data : dataInput) {
            root = insertNode(root, data);
        }

        printLeaves(root);
    }

}