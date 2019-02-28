import java.util.*;

/**
 * 680. Valid Palindrome II 
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 
 * 思路: 两端进行dfs
 * 
 */
public class Solution {

    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
            }
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            System.out.println(s.validPalindrome(in));
        }
    }
}