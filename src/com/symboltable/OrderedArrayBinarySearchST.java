/** 
 * Symbol table implementation with binary search
 * class represent an ordered symbol table of generic key-value pairs
 */
import java.util.NoSuchElementException;
 public class OrderedArrayBinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY  = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;
    // initialize an empty symbol table
    public OrderedArrayBinarySearchST() {
        this(INIT_CAPACITY); 
    }
    public OrderedArrayBinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals =(Value[]) new Object[capacity];
    }

    // resize the underlying arrays

    private void resize(int capacity) {
        assert capacity >= n;
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

/**
 * Returns the number of key-value in this symbol table.
 */
public int size() {
    return n;
}
/**
 * Returns true if the symbol table is empty.
 */

 public boolean isEmpty() {
     return size() == 0 ;
 }
/**
 * Returns the number of keys in this symbol table strictly less than key
 *  * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
 */
public int rank(Key key) {
    if(key == null) throw new IllegalArgumentException("argument to rank() is null");
    int lo = 0 ; int hi = n-1 ;
    while(lo <= hi) {
        int mid  = lo + (hi - lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0) hi = mid - 1 ;
        else if(cmp > 0) lo = mid + 1;
        else return mid;
    }
    return lo;

}
/***************************************************************************
    *  Ordered symbol table methods.
    ***************************************************************************/

   /**
     * Returns the smallest key in this symbol table.
     *
     * @return the smallest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0]; 
    }

    /**
     * Returns the largest key in this symbol table.
     *
     * @return the largest key in this symbol table
     * @throws NoSuchElementException if this symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n-1];
    }
/**
 * Inserts the specified key-value pair into the symbol table, overwriting the old value 
 * with thew new value if the symbol table already contains the specified key.
 * 
 * Deletes the specified key (and its associated value ) 
 * from the symbol table if the specified value is null.
 */
 public void put(Key key, Value val) {
    if(key == null) {
        throw new IllegalArgumentException("first argument to put is null");
    }
    if(val == null) {
        //delete(key);
        return;
    }

    int i = rank(key);
    // key is already exist in symbol table
    if(i < n && keys[i].compareTo(key) == 0) {
        vals[i] = val; // overwrite if already there
        return;
    }
    // insert new key-value pair
    if(n == keys.length) { // check the array size before insert
        resize(2*keys.length);
    }
    // i is rank here so that we can do down the path for insert
    for(int j = n; j > i ; j--) {
        keys[j] = keys[j-1];
        vals[j]  = vals[j-1];
    }
    keys[i] = key;
    vals[i] = val;
    n++;


 }
 public Value get(Key key) {

    if(key == null) throw new IllegalArgumentException("key is null to get()");
    if(isEmpty()) return null;
    int i  = rank(key);
    if(i < n && keys[i].compareTo(key) == 0) return vals[i];

    return null;
 }
  public void delete (Key key) {
      if(key == null ) throw new IllegalArgumentException("argument to delete() is null");
      if(isEmpty()) return;
      // compute rank
      int i = rank(key);
      // key not in table
      if(i == n || keys[i].compareTo(key) != 0) {
        return ;
      }

      for(int j = i ; j < n-1; j++) {
        keys[j] = keys[j+1];
        vals[j] = vals[j+1];
      }
      n--;
      keys[n] = null;
      vals[n] = null;

      // resize if 1/4 full

      if(n > 0 && n == keys.length/4) resize(keys.length/2);
      // assert check();
  }

    public static void main(String args[]) {
        OrderedArrayBinarySearchST<String, Integer> st = new OrderedArrayBinarySearchST<String, Integer>();
        st.put("A", 1);
        st.put("B", 2);
        st.put("C", 3);
        st.put("D", 4);
    }
 }