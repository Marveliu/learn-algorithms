import java.util.*;

// 70. Climbing Stairs
// 思路：斐波那契，dp
public class Solution {

    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // dfs 超时
    // public int climbStairs(int n) {
    // if (n < 0)
    // return 0;
    // if (n == 0)
    // return 1;
    // return climbStairs(n - 2) + climbStairs(n - 1);
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.climbStairs(sc.nextInt()));
        }
    }
}