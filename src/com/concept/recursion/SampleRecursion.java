package com.concept.recursion;

import com.sun.jmx.snmp.SnmpUnknownModelLcdException;

import java.util.Arrays;
import java.util.Scanner;

public class SampleRecursion {
    public static void main(String[] args) {
        int arr[] = new int[] {1,3,5,6};
       // System.out.println(Arrays.toString(recBubSort(arr, arr.length-1)));
        System.out.println(searchInsert(arr, 2));
    }

    public static int searchInsert(int[]nums, int target) {

        return binInsertSearch(nums, 0, nums.length -1 , target);
    }

    public static int binInsertSearch(int[]nums, int low, int high , int target) {

        if(low > high) {
            return low;
        }
        int mid = low + (high -low) /2 ;

        if(target == nums[mid]) {
            return  mid;
        } else if(target > nums[mid]) {
            return binInsertSearch(nums, mid+1, high, target);
        } else {
            return binInsertSearch(nums, low, mid -1, target);
        }

    }

    public static String firstAlphabet(String S) {
        // code here
        if(S!=null) {
            StringBuilder sb = new StringBuilder();
            String[]s = S.split(" ");
            for (int i = 0; i < s.length; i++) {
                String el = s[i];
                sb.append(el.charAt(0));
            }
            return  sb.toString();
        }
        return "";
    }
    private static void swap(int arr[], int index) {
        int temp = arr[index];
        arr[index] = arr[index +1];
        arr[index+1] = temp;
    }

    public static int[] recBubSort(int[]arr, int high) {
        if(high < 2)
            return arr;
        for (int i = 0; i < high-1 ; i++) {
            if(arr[i] > arr[i+1]) {
                swap(arr, i);
            }
        }
        return  recBubSort(arr, high -1);
    }
    public static int binSearch(int arr[], int low, int high, int target) {
        int location = -1; // target not found;
        if(low <= high)
        {
            int mid = (low + high)/2;
            if(target == arr[mid])
                location = mid;
            else if(target < arr[mid]) // first half
                location = binSearch( arr, low, mid - 1, target);
            else // second half
                location = binSearch(arr,mid + 1, high, target);
        }
        return location;
    }
    public static boolean What5(String s, int l, int r)
    {
        if( l >= r)
            return true;
        else
        if(s.charAt(l) != s.charAt(r))
            return false;
        else
        {
            l++;
            r--;
            return What5(s, l, r);
        } // else
    } // What2
    public static int What4( int[ ] arr, int start, int end, int val )
    {
        int len = end - start;
        if( len <= 0 )
            return 0;
        if( len == 1 )
            return arr[ start ] == val ? 1 : 0;
        int len2 = len / 2;
        int firstHalf =  What4( arr, start, start + len2, val );
        int secondHalf = What4( arr, start + len2, end, val );
        return  firstHalf + secondHalf;
    } //

    // input grades:
    public  static void inputGrades(int arr[] ,int n) {

        int grade = 0;

    }

   //  Print grades
    public  static void printGrades(int arr[]) {

    }
    // update grades
    public  static void updateGrades(int arr[]) {

    }
    public static int findMax(int arr[], int len) {
        if(len == 1) return arr[0];
        else {
            int result = findMax(arr,len -1);
            if(arr[len -1] > result){
                return arr[len -1];
            }else {
                return result;
            }

        }
    }

    public static int recSum(int arr[], int index) {
        if(index == arr.length) return  0;
        else return arr[index] + recSum(arr, index+1);
    }

    public static int rangeMulti(int[]arr, int start, int end) {
        if(start > end) return  1;
        else {
            return arr[start] * rangeMulti(arr, start + 1, end);
        }
    }
/*
Thus, there will be three recursive calls to display
all permutations of a three-letter word.
The base case of our recursion would be when we
reach a word with just one letter.
 */
    public  static void printAnagram(String prefix,String word) {
        if(word.length() <=1)
            System.out.println(prefix+word);
        else  {
            for (int i = 0; i < word.length(); i++) {
                System.out.println("i = " +i);
                String  current = word.substring(i,i+1);
                System.out.println("curr = " +current);
                String before = word.substring(0,i);
                System.out.println("before = " +before);
                String after = word.substring(i+1);
                System.out.println("after = " +after);
                printAnagram(prefix+current, before+after);
            }
        }
    }

    public static void recPrint(int arr[], int index) {
        System.out.print(arr[index]);
        if(index < arr.length -1) {
            System.out.print(",");
            recPrint(arr, index+1);

        }
    }


    public  static String reverseString(String s) {
        if(s.length() <=1)
            return s;
          return reverseString(s.substring(1)) + s.charAt(0);
    }
    public static int[] reverseArray(int[] arr, int len ) {

        if(len <= arr.length/2)
            return  arr;

        else {
            int temp = arr[len - 1];
            arr[len -1] = arr[arr.length - len];
            arr[arr.length - len] = temp;
            return reverseArray(arr, len -1);
        }

    }

    public static  int recLoop(int num) {
        if(num == 1) return 1;
        int sum = num;
        for(int i = 1; i < num; i++)
        {
            sum  = sum + recLoop(i);
        }
        return  sum;
    }

    public static double myPow(double x, int n) {

        if(n == 0 ) return 1;
        else {
            double partial = myPow(x,n/2);
            // double result = partial*partial;
            if(n%2 == 0) {
                return partial*partial;
            } else {
                if(n > 0) {
                    return partial*partial*x;
                }else {
                    return partial*partial/x;
                }
            }

        }
    }

    public static int What3 (int a, int b)
    {
        int ans;
        if (b == 0)
            ans = 1;
        else
        if (b % 2 == 0)
            ans = What3(a*a, b/2);
        else
            ans = What3(a*a, b/2) * a;
        return ans;
    }

    public static int What2(int x,int y)
    {
        if((x == 0) || (y == 0))
            return 0;
        else
        if((x % 10 ) == (y%10))
            return 1+ What2(x/10,y/10);
        else
            return(What2(x/10, y/10));
    }

    public static int divide(int a, int b)
    {
        if(b == 0)
            return 0;
        else
        if(a < b)
            return 0;
        else
        if(b == 1)
            return a;
        else
            return add(1, divide(sub(a,b),b));
    }

    // Base case  b == 0
    // Decomposition:  (a - 1) , (b +1)
    // Composition: add(a -1, b+1) , n < 0, add(a+1, b-1)  , n > 0
    public static  int sub(int a , int b) {
        int result = 0;
        if(b==0) return a;
        else  {
            if(b < 0 ) {
                return sub(a+1, b+1);
            }else {
                return sub(a+1, b -1);
            }
        }
    }
  // Base case  b == 0
  // Decomposition:  (a - 1) , (b +1)
  // Composition: add(a -1, b+1) , n < 0, add(a+1, b-1)  , n > 0
    public static  int add(int a , int b) {
        if(b==0) return  a;

        else {
            if(b< 0) { // for negative numbers
                return  add(a -1, b +1);
            } else {
                return  add(a+1, b -1);
            }
        }
    }
    /*
Decomposition: (x-1)
Composition: y + recMult(x-1)
Base case: x ==0;
 */
    public static int recMult(int x, int y) {

        if(x== 0) return  0;

        return y + recMult(x-1,y);

    }

    public static int power(int x, int y) {

        if(y <= 0) return  1;

        return x * power(x,y-1);

    }
/*
Decomposition: (n-1)
Composition: n + sigma(n-1)
Base case: n=1
 */
    public static int sigma(int n) {

        if(n <= 1) {
            return 1;
        }
        else {
            return n + sigma(n-1);
        }
    }

    public static int fact(int n) {

        if(n == 1) {
            return 1;
        }
        else {
            return fact(n-1) * n;
        }
    }

    public static int fibo(int n) {
        if(n < 2)
        return  n;
        return fibo(n-1) + fibo(n-2);
    }


    static int print(int n) {

        if(n == 5){
            System.out.println(n);
            return 0;
        }
        System.out.println(n);
      return print(n+1);
       // System.out.println(a);
       //return  a;
       // System.out.println("call ended");
    }
}
