import java.util.*;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * 最长回文字符串
 * 
 * 1. 动态规划 o(n^2)
 * 2. 马拉车算法 o(n) https://blog.csdn.net/dyx404514/article/details/42061017
 */
public class Solution {

    // 动态规划 dp[i][j] 表示字符串i->j是否为回文
    // 1. i = j true
    // 2. j - i = 1 charAt(i) == charAt(j) true
    // 3. charAt(i) == charAt(j) dp[i][j] = dp[i+1][j-1]
    // i from len-1 to 0
    // j from i to len-1
    // public String longestPalindrome(String s) {
    //     String ans = "";
    //     if (s == null || s.isEmpty())
    //         return ans;
    //     int len = s.length();
    //     boolean[][] dp = new boolean[len + 1][len + 1];
    //     for (int i = len - 1; i >= 0; i--) {
    //         for (int j = i; j < len; j++) {
    //             if (i == j)
    //                 dp[i + 1][j + 1] = true;
    //             else if (s.charAt(i) == s.charAt(j)) {
    //                 if (j - i == 1) {
    //                     dp[i + 1][j + 1] = true;
    //                 } else {
    //                     dp[i + 1][j + 1] = dp[i + 2][j];
    //                 }
    //             }
    //             if (dp[i + 1][j + 1] && j - i + 1 > ans.length())
    //                 ans = s.substring(i, j + 1);
    //         }
    //     }
    //     return ans;
    // }

    // manacher
    public String longestPalindrome(String s) {
        int mx = 0, po = 0;
        char[] ma = convert(s);
        int[] mr = new int[ma.length];
        int len = 0;
        int ans = 0;
        for (int i = 1; i < ma.length - 1; i++) {
            if (mx > i)
                mr[i] = Math.min(mx - i, mr[2 * po - i]);
            else
                mr[i] = 1;
            while (ma[i - mr[i]] == ma[i + mr[i]])
                mr[i]++;
            if (mr[i] + i > mx) {
                mx = mr[i] + i;
                po = i;
            }
            if(mr[i] > len){
                ans = i;
                len = mr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ans  - len + 1; i <=  ans + len -1; i++) {
            if(ma[i] == '^' || ma[i] == '$') continue;
            if(ma[i] != '#') sb.append(ma[i]);
        }
        return sb.toString();
    }

    public char[] convert(String s) {
        char[] cs = s.toCharArray();
        char[] ans = new char[cs.length * 2 + 3];
        ans[0] = '^';
        ans[ans.length - 1] = '$';
        ans[ans.length - 2] = '#';
        for (int i = 0; i < cs.length; i++) {
            ans[2 * i + 1] = '#';
            ans[2 * i + 2] = cs[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            System.out.println(s.longestPalindrome(in));
        }
    }
}