import java.util.*;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * 思路：动态规划 dp[i] 表示以i为结尾所有符合规则
 * 括号对数 (()） 判断 dp[i] 与 dp[i-dp[i-1]*2-1] 是否为括号对
 * 1. 否 dp[i] = 0;
 * 2. 是 dp[i] = dp[i-dp[i-1]*2-2] + dp[i-1] + 1 可能连上了之前括号对，例如()(())
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < s.length(); i++) {
            int n = dp[i];
            int prev = i - 2 * n - 1;
            if (prev >= 0 && s.charAt(prev) == '(' && s.charAt(i) == ')') {
                dp[i + 1] = n + 1 + (prev - 1 > 0 ? dp[prev] : 0);
            }
        }
        // System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int var : dp) {
            max = Math.max(max, var);
        }
        return max * 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            System.out.println(s.longestValidParentheses(in));
        }
    }
}

// "(()"
// ")()())"