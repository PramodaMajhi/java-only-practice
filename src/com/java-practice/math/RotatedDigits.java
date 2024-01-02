// package  com.java-practice.math;
class RotatedDigits {

    /*
    Couple of approach need to be discussed, if we create a map and put all rotable digits in map
    Such as 0, 8, 1 , 2,5 and 5,2, 6,9 and 9 ,6
    run a loop and until the range  and go one by one numbers check if its valid or not

    Second approach, Valid if B contians at least one 2,5,6,9 and No 3,4,or 7s
    */
    public int  rotatedDigits(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(isValid(i))
                count ++;
        }
        return count;
    }

    public boolean isValid(int N) {
        /*
         Valid if N contains ATLEAST ONE 2, 5, 6, 9
         AND NO 3, 4 or 7s
         */
        boolean validFound = false;
        while(N > 0 ) {
            if(N % 10 == 2)
                validFound = true;
            else if(N % 10 == 5)
                validFound = true;
            else if(N % 10 == 6)
                validFound = true;
            else if(N % 10 == 9)
                validFound = true;
            else if(N % 10 == 3)
                return false;
            else if(N % 10 == 7)
                return false;
            else if(N % 10 == 4)
                return false;
            N = N / 10;
        }
        return validFound;
    }

    public static void main(String[] args) {
        System.out.println("Rotated Digits");
        RotatedDigits obj  = new RotatedDigits();
        int count =  obj.rotatedDigits(10);
        System.out.println(count);

    }
}