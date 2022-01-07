import java.util.ArrayList;
import java.util.*;

/**
 * 2) XOR (^) (if and only if)
 * a ^ 1  = a~ (a's compliment)
 * a ^ 0   = a
 * a ^ a  = 0
 */
public class findUnique {
    public static void main(String[] args) {
        int []arr = {1,1,2,2,3};
        System.out.println(singleNumberMath(arr));
    }

    /**

     Approach 3: Math
     Concept

        2 * (a + b + c) - (a + a + b + b + c) = c

     */
    public static int singleNumberMath(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }
/*
We use hash table to avoid the O(n) time required for searching the elements.
Iterate through all elements in nums and set up key/value pair.
Return the element which appeared only once.
 */
    public int singleNumberHash(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
  /*
    1. Iterate over all the elements in nums
    2. If some number in nums, is new to array, append it
    3. If some number is already in the array, remove it.
       Time Complexity: O(n^2) , we iterate through the nums taking O(n) time
       We search for the whole list to find there is duplicate O(n)
       so we multiply both complexities O(n^2)
       Space Complexity: O(n) we need a list of size n to contain elements in nums

   */

    public  static int singleNumber(int []nums) {
        List<Integer> no_duplicate_list = new ArrayList<Integer>();
        for (int n: nums) {
            if(!no_duplicate_list.contains(n)) {
                no_duplicate_list.add(n);
            } else {
                no_duplicate_list.remove(new Integer(n));
            }
        }
        return  no_duplicate_list.get(0);
    }
/*
Approach 4: Bit Manipulation
Concept

If we take XOR of zero and some bit, it will return that bit
a^0=a
If we take XOR of two same bits, it will return 0
a^a = 0
a^b^a=(a^a)^b=0^b=b
So we can XOR all bits together to find the unique number.
    Time Complexity: O(N) We only iterates through the nums, so the time complexity
    is the number of elements in nums.
    Space Complexity: O(1)
 */
    private static int ans(int[] arr) {
        int unique = 0;
        for(int n: arr) {
            unique = unique^n;
        }
        return unique;
    }
}