import java.util.*;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * 
 * 从左上角到有下角，所有的路径和
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        if (m >= 1) {
            dp[1][0] = 1;
        } else if (n >= 1) {
            dp[0][1] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int m = sc.nextInt();
            sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            System.out.println(s.uniquePaths(m, n));
        }
    }
}