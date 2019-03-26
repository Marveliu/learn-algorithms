import java.util.*;

/**
 * [编程题] 最小编辑代价
 * 
 * https://www.nowcoder.com/profile/6851726/test/22591667/25107#summary
 */
public class Solution {

    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i * c1;
        for (int i = 0; i <= m; i++)
            dp[0][i] = i * c0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i][j + 1] + c1;
                    int b = dp[i + 1][j] + c0;
                    int c = dp[i][j] + c2;
                    int d = dp[i][j] + c0 + c1;
                    int min = Math.min(Math.min(a, b), Math.min(c,d));
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            int c0 = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            sc.nextLine();
            System.out.println(s.findMinCost(A, A.length(), B, B.length(), c0, c1, c2));
        }
    }
}