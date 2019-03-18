import java.util.*;

/**
 * 115. Distinct Subsequences
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * S:rabbbit  T:rabbit  S有三种方式构建T
 * 
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 
 * 状态转移：
 * dp[i][j] 表示T[i]与S[j]的所有的组合
 * init 当T为空的话，S可以构建一次，即dp[0][j] = 1
 * 当T[i] == S[j]，则
 * dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
 * 不等，则
 * do[i][j] = dp[i][j-1];
 * 
 */
public class Solution {

    public int numDistinct(String S, String T) {
        // array creation
        int[][] dp = new int[T.length() + 1][S.length() + 1];

        // filling the first row: with 1s
        for (int j = 0; j <= S.length(); j++) {
            dp[0][j] = 1;
        }
        
        // the first column is 0 by default in every other rows but the first, which we
        // need.
        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[T.length()][S.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            // System.out.println(visit.computeIfAbsent("tet", v -> 1));
            String ss = sc.nextLine();
            String tt = sc.nextLine();
            // System.out.println(ss.substring(0, 0) + ss.substring(1, ss.length()));
            // String test = "100";
            // System.out.println(s.setVisit(test, 4));
            int ans = s.numDistinct(ss, tt);
            System.out.println(ans);
        }
    }
}

// rabbbit
// rabbit

// babgbag
// bag

// bccbcdcabadabddbccaddcbabbaaacdba
// bccbbdcbabgbag