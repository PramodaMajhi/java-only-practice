
/**
 * The class represents an ordered symbol table of generic key-value pairs. This
 * implementation uses an (unbalanced) <em>binary search tree * It requires that
 * the key type implements the {@code Comparable} interface and calls the
 * {@code compareTo()} and method to compare two keys. It does not call either
 * {@code equals()} or {@code hashCode()}.
 * 
 * Tree shape depends on order of insertion Best case: Tree is balanced he shape
 * of the, of the tree could be well in the best case so it would be perfectly
 * balanced. And one of the things we'll look at is algorithms that come very,
 * very close to achieving that goal. The typical, typical case it'll be sort of
 * balanced. Now but one problem is if the keys come in and, and really
 * unfortunately, if they come in, in a natural order. Like if they come in, in
 * order, that's the worst case. We don't get any benefit from having it in a
 * tree shape. It's no different than a link list.
 * 
 * Many BSTs corresponds to same set of keys Numner of compares for
 * search/insert is equal to 1+depth of node.
 * 
 * In fact, this correspondence with Quicksort partitioning tells us we can take
 * that proof and prove that if you insert in distinct keys into a BST, in
 * random order, then the expected number of compares for a search and an insert
 * is two natural log N. So again about 1.38 log base two of N almost the best
 * that you could do. It also has been shown actually not that long ago, that
 * the expected height of the tree if they're inserted in random order, the
 * height that's the worst case length of a path in the tree. This is the
 * average path in a tree, this is the, the worst of all the keys. This is about
 * four natural log N. So, if you have the keys in random order the binary
 * search tree gives efficient search and insert. Now but there is this problem
 * that the actual worst case height if the keys come in, in order and reverse
 * order and other natural orders that the time could be proportional to n. So,
 * we have this summary which is looking pretty good, because we have the
 * average case for both operations, the search and insert, to be 1.39 log N and
 * that's probabilistic if they are in random order, its extremely likely to be
 * there But the problem by comparison with sorting is, we don't get to
 * randomize the order the client is providing the keys. So we're going to need
 * something better to provide the guarantee than just randomly ordering the
 * keys
 * 
 * Compelexity:
 * ordered iteration is optimal, it just gets them in linear time. 
 * And all the rest of them take time proportional to the height of the tree. Now, 
 * if the, the keys are inserted in random order, we know that height by analysis, 
 * is going to be proportional to log N
 */
import java.util.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right; // left for smaller key and right for larger key
        private int size; // number of node in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    // Initialize empty symbol table
    BinarySearchTree() {

    }

    /**
     * Returns true if this symbol table is empty;
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table is empty;
     */
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        else
            return root.size;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the
     * old value with the new value if the symbol table already contains the
     * specified key. Deletes the specified key (and its associated value) from this
     * symbol table if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("call put() with null key");
        if (val == null) {
            // delete(key);
            return;
        }

        root = put(root, key, val);
    }

    /**
     * 
     * @param root
     * @param key
     * @param val
     * @return
     */

    public Node put(Node root, Key key, Value val) {
        if (root == null)
            return new Node(key, val, 1); // 1 is size here
        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            root.left = put(root.left, key, val);
        else if (cmp > 0)
            root.right = put(root.right, key, val);
        else
            root.val = val;
        root.size = 1 + size(root.left) + size(root.right);
        /**
         * we return, x.count, which is the number of nodes in that, in that subtree by
         * definition. The way we maintain, there's a number of ways we can maintain the
         * thing but the one that we'll adopt un iformly because it adapts to more
         * complicated situations is just before we're done with the put operation we'll
         * say, okay we've done all our work and before we return the pointer to the
         * given subtree we're going to take the size of what's on the left and the size
         * of what's on the right and add one for us and that's going to be our count.
         */
        return root;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol
     *         table and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    public Value get(Key key) {

        return get(root, key);
    }

    public Value get(Node root, Key key) {

        if (key == null)
            throw new IllegalArgumentException("key null in get()");
        if (root == null)
            return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            return get(root.left, key);
        else if (cmp > 0)
            return get(root.right, key);
        else
            return root.val;

    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}. To iterate over
     * all of the keys in the symbol table named {@code st}, use the foreach
     * notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys() {
        if (isEmpty())
            return new ArrayList<Key>();
        return keys(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range, as an
     * {@code Iterable}.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} (inclusive) and
     *         {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi} is
     *                                  {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.add(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    /**
     * Returns the keys in the BST in level order (for debugging).
     *
     * @return the keys in the BST in level order traversal
     */
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new LinkedList<Key>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node x = queue.remove();
            if (x == null)
                continue;
            keys.add(x.key);
            queue.add(x.left);
            queue.add(x.right);
        }
        return keys;
    }

    /**
     * let's look at the, at the three cases. So, we want to know the number of keys
     * less than K. So we're going to have a recursive algorithm for our given key.
     * So, let's, one of the easy ones is, if our key is equal to the, if were to
     * the, the key at the current node then the number of keys less than our key is
     * the size of the left subtree of that node. So, if we're looking for the rank
     * of E say, how many keys are there less than E there's exactly two, that's by
     * definition in the data structure that's the number of keys that are less than
     * E. So, that's that one for rank. What about the starting at the root if we
     * have the case where E is less than S. So, the rank of E in this whole tree is
     * the same as the rank of E in the left subtree. So, there's that case and then
     * if we're going to the right, then we have to add one for the root and one for
     * the left subtree of the root and then find the rank of us on the right. So,
     * that's an easy recursive algorithm for finding out the rank.
     * 
     * 
     * @return
     */
    public int rank(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to rank() is null");

        return rank(root, key);
    }

    public int rank(Node root, Key key) {
        if (root == null)
            return 0;
        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            return rank(root.left, key);
        else if (cmp > 0)
            return rank(root.right, key);
        else
            return size(root.left);
    }

    /**
     * So like deleting R in this tree,it only has one child.Just go ahead and
     * return the link to that child,and that updates the link and everything works
     * fine.And the node that was deleted is available for garbage
     * collections,nobody's pointing to it.And again, update all the counts after
     * the recursive calls.So zero children no problem,one child no problem.The
     * problem is, what happens when there's two children?So say, we want to delete
     * node E in this tree.We have only one link and we can get rid of the node,but
     * we have only one link pointing to it,but we have two links pointing down from
     * it.So what are we going to do with those two links?Well, the Hibbard deletion
     * mechanism which is pretty old,50 years ago it was proposed,says go ahead and
     * find the next smallest node in the right sub-tree of that tree.In this case,
     * that's H. What's that node?Well, it's the minimum in T's right sub-tree.And
     * we know how to delete the minimum.So we just find that minimum node.And in
     * this case it's H,and we put that node in T spot and then delete the
     * minimum.So find the H, that's the minimum,hang on to it, and then delete the
     * minimum in T's sub-tree.So we take the E, replace it with the H,and delete
     * the H, and then everything's fine.That's still a BST.Essentially, we're
     * finding a node that has only one link leading that node,and then replacing
     * the node that we need to delete with that one.That's Hibbard deletion.It's a
     * little bit asymmetric.Why are we using the successor,and not the
     * predecessor?No real reason.It's not really satisfactory because of that,and
     * we'll come back to this, but it works
     */
    public void delete(Key key) {
        root = delete(root, key);
    }
    /**
     *      s
     *     / \ 
     *    E   X
     *   / \  /\ 
     *  A   R
       / \  / \ 
    null  C H 
           / \ 
                M 
                /\
       
     * @param root
     * @param key
     * @return
     */

    public Node delete(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(root.right, key);
        } else {
            /**
             * So we search for the key, if it's got no right child we're fine, we just
             * return x.left and that the handles both cases zero and one.
             */
            // This is hibbard deletion 
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            Node t = root;
            root = min(root.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    /**
     * Removes the smallest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        // assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the largest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        // assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the largest key in the symbol table less than or equal to
     * {@code key}.
     *
     * @param key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException   if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null)
            throw new NoSuchElementException("argument to floor() is too small");
        else
            return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    /**
     * Returns the smallest key in the symbol table greater than or equal to
     * {@code key}.
     *
     * @param key the key
     * @return the smallest key in the symbol table greater than or equal to
     *         {@code key}
     * @throws NoSuchElementException   if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null)
            throw new NoSuchElementException("argument to floor() is too large");
        else
            return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null)
                return t;
            else
                return x;
        }
        return ceiling(x.right, key);
    }

    public static void main(String args[]) {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
        bst.put("S", 8);
        bst.put("E", 4);
        bst.put("X", 12);
        bst.put("A", 5);
        bst.put("C", 11);
        bst.put("R", 9);
        bst.put("H", 10);
        bst.put("M", 3);
        // bst.put("S", 0);
        // bst.put("X", 7);

        // for (String s : bst.levelOrder())
        // System.out.println(s + " level " + bst.get(s));

        for (String s : bst.keys())
            System.out.println(s + " " + bst.get(s));
        bst.delete("E");
        // bst.delete("R");
        // bst.delete("S");
        // bst.delete("X");
        System.out.println("-------------");
        for (String s : bst.keys())
            System.out.println(s + " " + bst.get(s));
    }

}
