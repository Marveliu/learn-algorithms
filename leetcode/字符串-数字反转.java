import java.util.*;


/**
 * 7. Reverse Integer
 * 
 * https://leetcode.com/problems/reverse-integer/
 * 
 */
public class Solution {

    public int reverse(int x) {
        boolean pos = true;
        if (x < 0)
            pos = false;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        long abs = Math.abs((long) x);
        String s = String.valueOf(abs);
        s = new StringBuffer(s).reverse().toString();
        long ans = Long.valueOf(s);
        if (ans > Integer.MAX_VALUE)
            return 0;
        return (int) (pos ? ans : 0 - ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.reverse(sc.nextInt()));
        }
    }
}