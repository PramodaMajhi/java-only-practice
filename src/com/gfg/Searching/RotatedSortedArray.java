package com.gfg.Searching;

public class RotatedSortedArray {
    public int search(int[]nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] >= nums[low]) {
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if(target <= nums[high] && target > nums[mid])
                {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArray search = new RotatedSortedArray();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int ans = search.search(nums,target);
        System.out.println(ans);
    }
}
