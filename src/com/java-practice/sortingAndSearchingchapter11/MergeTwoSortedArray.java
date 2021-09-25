public class MergeTwoSortedArray {
    
   
   
    public static void mergeTwoSortedArray(int a[], int b[], int countA, int countB) {
        int indexMerged = countA + countB - 1; // last location of the merged array
        int indexA = countA -1; // Index of last element in array a
        int indexB = countB -1; // index of last element in array b

        while(indexB >=0) {
            if(indexA>=0 && a[indexA] > b[indexB])  {
                // end of A is bigger than end of B
                a[indexMerged] = a[indexA]; // copy element
                indexA --;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB --;
            }
            indexMerged --;
        }
    }

    public static void main(String args[]) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 7, 6, 7, 7};
        mergeTwoSortedArray(a, b, 8, 6);

        for (int i : a) {
            System.out.println(i);
        }
    }
}
