package com.SDEPractice;

public class Jan16 {

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(input));
    }
/*
IDEA:
    If corresponding bits are different then must use XOR
    Also there is a built-in function to calculate bit
//^  operator returns 1 if and only if one of the operands is 1
    XOR (^) (if and only if)
    a ^ 1  = a~ (a's compliment)
    a ^ 0   = a
    a ^ a  = 0

// ~ It changes binary digits 1 to 0 and 0 to 1.
// It is important to note that the bitwise complement of any integer N is equal to - (N + 1).

 */
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x^y);
    }

    /*
        388. Longest Absolute File Path
        Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
        Output: 20
        Explanation: We have only one file, and the absolute
        path is "dir/subdir2/file.ext" of length 20.
     */
    public static int lengthLongestPath(String input) {
        // Depth of directory can be calculated by t

        String[] subDir = input.split("\n");
        if(subDir.length == 0 ) return 0;

        for(int i = 0; i < subDir.length; i++) {
            int level = subDir[i].lastIndexOf('\t') +1;
            System.out.println(level);
        }
        return 0;
    }

}
