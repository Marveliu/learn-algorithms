import java.util.*;

// 680. Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/

// 思路:模拟 贪心算法
public class Solution {

    // greedy
    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i))
                return false;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
            }
        }
        return true;
    }

    // public boolean validPalindrome(String s) {
    // if (s == null)
    // return false;
    // return check(0, s.length() - 1, s, false);

    // }

    // public boolean check(int start, int end, String s, Boolean flag) {
    // while (start <= end && start < s.length() && end >= 0) {
    // if (s.charAt(start) != s.charAt(end)) {
    // if (!flag) {
    // flag = true;
    // return check(start,end-1,s, flag) || check(start+1,end,s, flag);
    // } else {
    // return false;
    // }
    // }
    // start++;
    // end--;
    // }
    // return true;
    // }

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