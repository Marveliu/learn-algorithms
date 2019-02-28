import java.util.*;
/**
 * 132. Palindrome Partitioning II
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。（0,i）的子串中包括了i+1个字符。
 * 分两种情况：
 * 
 * 1. 初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
 * 2. 对于任意大于1的i，如果s.substring(j,i+1)( 1 =< j <=  i ,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1); 
 */
public class Solution {

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : dp[i - 1] + 1;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[j - 1] + 1 + (isPalindrome(s.substring(j, i + 1)) ? 0 : i - j));
            }
        }
        return dp[s.length() - 1];
    }

    public static boolean isPalindrome(String s) {
        int middle = s.length() / 2;
        for (int i = 0; i <= middle; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            System.out.println(s.minCut(in));
        }
    }
}