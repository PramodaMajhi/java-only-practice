package com.arrays.practiceproblem;

public class Array1Practice {

    public static void main(String[] args) {
        int[]a = {1, 7};
        int[] b = {};
        int arr[] = front11(a,b);
        // rotateLeft(nums);
        //int rev[] = reverse3(nums);
       // int mid[] = makeMiddle(nums);
       //  int arr[] = swapEnds(a);
       // int mid[] = plusTwo(a, b);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] front11(int[] a, int[] b) {
        int[] arr = new int[1];
        if(a.length!=0 && b.length!=0) {
            return  new int[]{a[0], b[0]};
        }
        if(a.length == 0 && b.length!= 0) {
            arr[0] = a[0];
            return arr;
        }
        if(a.length!= 0 && b.length == 0) {
            arr[0] = b[0];
            return arr;
        }
        return arr;

    }

    public static int maxTriple(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int[] swapEnds(int[] nums) {
        int temp = nums[nums.length - 1];
        nums[0] = temp;
        return nums;
    }
    public static int[] plusTwo(int[] a, int[] b) {
        int[] arr = new int[a.length + b.length];
        for(int i=0; i < a.length; i ++) {
            arr[i] = a[i];
        }
        for(int j = a.length, k =0; j < arr.length; j++, k++) {
            arr[j] = b[k];
        }
        return arr;

    }

    public static int[] makeMiddle(int[] nums) {
        int a =  (nums.length/2 -1);
        int b = nums.length/2;
       return new int[]{
              nums[a], nums[b]
       };
    }

    public static int[] rotateLeft(int[] nums) {
        int temp = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = temp;
        return nums;
    }

    public static int[] reverse3(int[] nums) {
        int newArr[] = new int[nums.length];
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            newArr[j++] = nums[i];

        }
        return newArr;

    }

    public static int[] reverse4(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[0] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
        return nums;
    }

    public static int[] maxEnd3(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[0]) {
                max = nums[0];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = max;
        }
        return nums;
    }
}
