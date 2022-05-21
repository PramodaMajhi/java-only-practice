
public class Operator {
    /*
    12 = 00001100 (In Binary)
    25 = 00011001 (In Binary)

    // Bitwise AND Operation of 12 and 25
       00001100
     & 00011001
    ____________
       00001000 = 8 (In Decimal)
     */

    /*

     */

    public static void main(String[] args) {

        int a = 12;
        int b = 25;
        // | operator returns 1 if at least one of the operands is 1. Otherwise, it
        System.out.println(a|b);
        // & operator returns 1 if and only if both the operands are 1.
        System.out.println(a&b);
      //^  operator returns 1 if and only if one of the operands is 1
        System.out.println(a^b);
        // ~ It changes binary digits 1 to 0 and 0 to 1.
        // It is important to note that the bitwise complement of any integer N is equal to - (N + 1).

        int number = 35, result;
        result  = ~number;
        System.out.println(result);

        // << operators, shifts all bits towards the left by a certain number of
        // specified bits.

        int number1 = 2;

        // 2 bit left shift operation
        int result1 = number1 << 2;
        System.out.println(result1);    // prints 8

        int number3 = 8;
        int number4 = -8;

        // 2 bit signed right shift
        System.out.println(number3 >> 2);    // prints 2
        System.out.println(number4 >> 2);    // prints -2
    }


}