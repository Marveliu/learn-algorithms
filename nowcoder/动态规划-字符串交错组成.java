import java.util.*;

/**
 * 字符串交错组成
 * 
 * https://www.nowcoder.com/profile/6851726/test/22591667/25108#summary
 */
public class Solution {

    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == C.charAt(i)) {
                dp[i + 1][0] = true;
            } else {
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (B.charAt(j) == C.charAt(j)) {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            char a = A.charAt(i);
            for (int j = 0; j < m; j++) {
                char b = B.charAt(j);
                int p = i + j + 1;
                char cur = C.charAt(p);
                if ((cur == a && dp[i][j + 1]) || (cur == b && dp[i + 1][j])) {
                    dp[i + 1][j + 1] = true;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            String A = sc.nextLine();
            String B = sc.nextLine();
            String C = sc.nextLine();
            System.out.println(s.chkMixture(A, A.length(), B, B.length(), C, C.length()));
        }
    }
}