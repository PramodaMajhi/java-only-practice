package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

public class RemovePalindromeSub {
    public int removePalindromeSub(String s) {
        int count = 0;
        if(s.length() == 0) return count;
        int start = 0, end = s.length()-1;
        while (start < end) {
            if(s.charAt(start) == s.charAt(end)){
            }else {
                count++;
            }
            start++;
            end--;
        }
        count  = (count == 0) ? 1 : 2;
        return count;
    }

    public static void main(String[] args) {
        String  s = "baabb";
        RemovePalindromeSub remove = new RemovePalindromeSub();
        int ans = remove.removePalindromeSub(s);
        System.out.println(ans);
    }
}
