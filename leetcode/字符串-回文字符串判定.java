import java.util.*;
/**
 * 
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * 思路:模拟
 * 双指针，向中间进行逼近，遇到非字母符号，进行跳跃
 * 
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end && start < s.length() && end >= 0) {
            if (!isValid(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isValid(s.charAt(end))) {
                end--;
                continue;
            }
            if (toLowwerCase(s.charAt(start)) != toLowwerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public char toLowwerCase(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return c;
        }
        return (char) (c + ('a' - 'A'));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            System.out.println(s.isPalindrome(in));
        }
    }
}