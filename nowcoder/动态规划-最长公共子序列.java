import java.util.*;

/**
 * 最长公共子序列
 * 
 * https://www.nowcoder.com/profile/6851726/test/22591667/25105#summary
 */
public class Solution {

    public int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
                ans = Math.max(ans, dp[i + 1][j + 1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            String A = sc.nextLine();
            String B = sc.nextLine();
            System.out.println(s.findLCS(A, A.length(), B, B.length()));
        }
    }
}