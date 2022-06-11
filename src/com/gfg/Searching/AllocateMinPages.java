package com.gfg.Searching;

public class AllocateMinPages {
    /*
        Method to find minimum pages
     */
    public int findPages(int[] arr, int k) {
        int sum = 0;
        // return -1, if no. of books is less than no of students
        if (arr.length < k)
            return -1;
        // count no. of pages
        for (int num : arr) {
            sum += num;
        }
        // Initialize low as 0 pages and high as total pages
        int low = 0, high = sum;
        int result = Integer.MAX_VALUE;
        while (low <= high) {
            // check it is possible to distribute
            // books by using mid as current minimum
            int mid = (low + high) / 2;
            if (isFeasible(arr, k, mid)) {
                // update result to the current distribution
                // as its the best we have found till now
                result = mid;
                // as we are finding minimum and books
                // are sorted so reduce high = mid -1
                // that means
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public boolean isFeasible(int[] arr, int k, int curr_min) {
        int studentRequired = 1;
        int curr_sum = 0;
        // iterate over all books
        for (int i = 0; i < arr.length; i++) {
            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min) {
                return false;
            }
            // count how many students are required
            // to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min) {
                // increment student count
                studentRequired++;
                // update curr_sum
                curr_sum = arr[i];
                // if students required becomes greater
                // than given no. of students,return false
                if (studentRequired > k)
                    return false;
            }
            // else update curr_sum
            else
                curr_sum += arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        //Number of pages in books
        int arr[] = {12, 34, 67, 90};
        int k = 2;
        AllocateMinPages allocateMinPages = new AllocateMinPages();
        int ans = allocateMinPages.findPages(arr,k);
        System.out.println(ans);
    }
}
