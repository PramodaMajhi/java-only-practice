public class OddOrEven {
    public static void main(String args[]) {
        int n = 10;
        System.out.println(isOdd(n) ? "Odd" : "Even");
    }

    private static boolean isOdd(int n) {
        return ((n & 1) == 1);
    }

}