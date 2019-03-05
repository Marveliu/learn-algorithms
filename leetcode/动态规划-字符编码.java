import java.util.*;

/**
 * 91. Decode Ways
 * 
 * https://leetcode.com/problems/decode-ways/
 * 
 * 
 * 思路：动态规划
 * dp[i] 表示以s.charAt(i)结尾所有解
 * dp[i] = (s[i]是否可以编码) + (s[i-1,i]是否可以编码, 如果是则加上dp[i-1]）
 */
public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        if (check(s.substring(0, 1))) {
            dp[1] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (check(s.substring(i, i + 1))) {
                dp[i + 1] += dp[i];
            }
            if (check(s.substring(i - 1, i + 1))) {
                dp[i + 1] += dp[i - 1];
                if (i - 1 == 0) {
                    dp[i + 1]++;
                }
            }
        }
        return dp[s.length()];
    }

    // 检查是否可以编码
    public boolean check(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        Integer item = Integer.valueOf(s);
        if (item >= 1 && item <= 26) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int ans = s.numDecodings(in);
            System.out.println(ans);
        }
    }
}

// 012