package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.Arrays;

public class MergeTwoSortedArray {
    /**
        IDEA: Two pointer approach, as its sorted
        we know the largest element in the end of the array

     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIndex = (m + n) -1 ;
        int lastElementOfA = m - 1;
        int lastElementOfB = n - 1;

        while(lastElementOfB >= 0) {
            if(lastElementOfA >=0 && nums1[lastElementOfA] > nums2[lastElementOfB]) {
                nums1[mergeIndex--] = nums1[lastElementOfA--];
            } else {
                nums1[mergeIndex--] = nums2[lastElementOfB--];
            }

        }
        System.out.println(Arrays.toString(nums1));
    }
    public void mergeClean(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
       int[] nums1 = {0};
       int m = 0;
       int[] nums2 = {1};
       int n = 1;

       // [1,2,2,3,5,6]
       MergeTwoSortedArray obj = new MergeTwoSortedArray();
       obj.merge(nums1,m, nums2,n);
       obj.mergeClean(nums1,m, nums2,n);
    }

}
