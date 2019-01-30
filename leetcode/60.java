import java.util.*;

// 91. Decode Ways
// 思路：动态规划
public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // dp[i] 表示以s.charAt(i)结尾所有解
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
        // System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

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