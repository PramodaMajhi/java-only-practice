/**
 * we had a single temporary four note and we split it up into a two, two note
 * not connected to a four note. And then, so that's the case when it's smaller.
 * Now, we have to look at the third case, which is, when it's, the new node
 * inserted this in between and comes out of this link here. Again, we just had
 * a red link and now we have a BST with two red links along the path connected
 * to A and that's not allowed. In this case it's a bit trickier to affix the
 * situation, what we do is we rotate the bottom link left. So, and that gives
 * us this and reduce it to the other situation that we had before. And then we
 * rotate the top link right and then, we flip the colors. So, this one we used
 * all three of our operations, rotate left rotate right and flip the colors.
 * And that gets us an insertion into a tree that has from a tree that i s a
 * single three node to a tree that is three two nodes that is containing three
 * keys. So that sort of operation is going to work in a big tree when we insert
 * into a new three node at the bottom. We do the standard BST insert, color the
 * new link red, and we do the rotations that we need, either one or two
 * rotations to balance the temporary four node, and then we flip colors to pass
 * the red link up one level and then remind me to rotate to that to make that
 * one lean left. So, for example if we insert h in to this tree here, it comes
 * off as the left link of R so that gives us a temporary four node that's not
 * balanced so we need to rotate the link from S to the right and that gives us
 * now temporary four node that is balanced and again, these are all local
 * transformation it's not changing the rest of the tree. Now, we flip colors
 * and that gives us a, a good red-black tree, except that, that one red link
 * that we just is leaning the wrong way. So, now we need to rotate left and
 * then once we've done that, now we have a legal left-leaning red-black tree.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root; // root of the Red Black BST

    private class Node {
        private Key key; // key
        private Value val; //
        private Node left, right;
        private boolean color;
        private int size; // sub tree count

        Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }

    }

    // initialize empty symbol table

    public RedBlackBST() {

    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null)
            return 0;
        return x.size;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * 
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // Insert a new node.
    public void put(Key key, Value val) {

        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, RED, 1);
        }

        // compare the key where to insert
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);

        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val; // overrite the old value
        }
        // do local transforamtion to balance to tree.
        // fix-up any right-leaning links

        // if(isRed(h.right) && !isRed(h.left)) {
        // h = rotelateLeft(h);
        // }
        // if(isRed(h.left) && isRed(h.left.left) ) {
        // h = rotateRight(h);
        // }
        // if(isRed(h.left) && isRed(h.right)) {
        // flipColors(h);
        // }

        // count size
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");

        Node x = get(root, key);
        return x.val;
    }

    private Node get(Node h, Key key) {

        if (h == null)
            return null;
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h = get(h.left, key);
        } else if (cmp > 0) {
            h = get(h.right, key);
        } else {
            return h;
        }

        return h;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Key should not be null");
        delete(root, key);
    }
  /**
             S
           /   \ 
    temp  E      X
         / \    / \ 
        A    R
       / \  / \ 
    null  C H -> min(t.right)
           /  \ 
                M 
                /\
       
     * @param root
     * @param key
     * @return
     */
    private Node delete(Node h, Key key) {
        if(h == null)  return null;
        int cmp = key.compareTo(h.key);
        if(cmp < 0) {
           h.left =  delete(h.left,key);
        } else if(cmp > 0){
           h.right = delete(h.right, key);
        } else {
            // found the key to delete
            // Case I: Node has no  child
            // Case II: Node has one  child
            // Case III: Node has two child
            if(h.left == null) {
                return h.right;
            }
            if(h.right == null) {
                return h.left;
            }
            // CASE -III where case has both children
            Node temp = h;
            h = min(h.right); // find the minimum of right subtree.
            h.right = deleteMin(temp.right); // successor
            h.left = temp.left;
            h.size = size(h.left) + size(h.right) + 1;

        }
        return h;
    }

    public Node deleteMin(Node x) {
         if(x.left == null) {
             return x.right;
         }
         deleteMin(x.left);
         return x;
    }

    public Key min() {
        return min(root).key;
    }
    public Node min(Node x) {
        if(x.left == null) return x;
        else {
            return min(x.left);
        }
    }

    /***************************************************************************
     * Node helper methods.
     ***************************************************************************/
    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    public static void main(String args[]) {

        RedBlackBST<String, Integer> rbst = new RedBlackBST<String, Integer>();
        rbst.put("S", 1);
        rbst.put("X", 2);
        rbst.put("E", 3);
        rbst.put("C",4);
        rbst.put("A",5);
        rbst.put("R",6);
        rbst.put("H",7);
        rbst.put("M",8);
        System.out.println(rbst.get("E"));
        rbst.delete("E");
        //System.out.println(rbst.get("E"));
    }

}