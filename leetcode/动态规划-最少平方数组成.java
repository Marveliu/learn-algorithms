import java.util.*;

/**
 * 279. Perfect Squares
 * 
 * https://www.youtube.com/watch?v=BT7qmMpUBKE
 * 
 * 思路：动态规划，每个最小的组合即使在之前求得数组合的基础上
 */
public class Solution {

    public int numSquares(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int local_res = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                local_res = Math.min(local_res, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = local_res;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            System.out.println(s.numSquares(sc.nextInt()));
        }
    }
}