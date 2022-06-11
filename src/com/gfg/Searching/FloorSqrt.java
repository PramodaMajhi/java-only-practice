package com.gfg.Searching;

public class FloorSqrt {
    // Naive solution
    public int floorSqrt(int x){
    //Base cases
    if(x == 0 || x == 1)
        return 1;
    // Starting from 1, try all numbers until i*i is greater than or equal to x
        int i = 1;
        while (i*i <=x){
            i++;
        }
        return i - 1;// because we are looking for floor of the sqrt
    }

    public int floorSqrtBinarySearch(int x){
        // Do Binary Search for floor(sqrt(x))
        int low = 1, high = x, ans=-1;
        while (low <= high)
        {
            int mid = low + (high-low) / 2;
            int sqr = mid*mid;
            // If x is a perfect square
            if (sqr == x)
                return (int)mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            else if (sqr < x)
            {
                low = mid + 1;
                ans = mid;
            }
            else   // If sqr is greater than x
                high = mid-1;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        FloorSqrt sqrt = new FloorSqrt();
        int x = 11;
        int ans = sqrt.floorSqrt(x);
        int bans = sqrt.floorSqrtBinarySearch(x);
        System.out.println(ans);
        System.out.println(bans);
    }
}
