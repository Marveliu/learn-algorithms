import java.util.*;


/**
 * 
 * 516. Longest Palindromic Subsequence
 * 
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * 1. i > j，dp[i][j] = 0； 
 * 2. i == j，dp[i][j] = 1； 
 * 3. i < j且s[i] == s[j]，dp[i][j] = dp[i + 1][j - 1] + 2； 
 * 4. i < j且s[i]！= s[j]，dp[i][j] = max(dp[i + 1][j]，dp[i][j - 1])；
 */
public class Solution {

    
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    // 超时
    // public int longestPalindromeSubseq(String s) {
    //     if (s.isEmpty())
    //         return 0;
    //     int l = 0;
    //     int r = s.length() - 1;
    //     int ans = 0;
    //     if (l == r)
    //         return 1;

    //     if (s.charAt(l) == s.charAt(r)) {
    //         ans += 2;
    //         l++;
    //         r--;
    //         ans += longestPalindromeSubseq(s.substring(l, r + 1));
    //     } else {
    //         int left = longestPalindromeSubseq(s.substring(l, r));
    //         int right = longestPalindromeSubseq(s.substring(l + 1, r + 1));
    //         ans += Math.max(left, right);
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.longestPalindromeSubseq(sc.nextLine()));
        }
    }
}

