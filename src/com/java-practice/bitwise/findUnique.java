/**
 * 2) XOR (^) (if and only if)
 * a ^ 1  = a~ (a's compliment)
 * a ^ 0   = a
 * a ^ a  = 0
 */
public class findUnique {
    public static void main(String[] args) {
        int []arr = {2,3,3,4,2,6,4};
        System.out.println(ans(arr));
    }

    private static int ans(int[] arr) {
        int unique = 0;
        for(int n: arr) {
            unique = unique^n;
        }
        return unique;
    }
}