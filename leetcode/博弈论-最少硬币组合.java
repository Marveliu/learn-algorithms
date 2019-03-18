import java.util.*;


/**
 * 322. Coin Change
 * 
 * https://leetcode.com/problems/coin-change/
 * 
 * 求出指定总额，硬币组合的数目最少的情况
 * 
 * dp[i] 表示当前总额下最少的硬币组合
 * dp[i-var] var表示硬币所有可能的面值，如果存在，则表示只需要一枚硬币即可得到总额i
 * 
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int var : coins) {
                int offset = i - var;
                if (offset >= 0 && dp[offset] != -1) {
                    dp[i] = (dp[i] == -1 ? dp[offset] + 1 : Math.min(dp[offset] + 1, dp[i]));
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.coinChange(StringUtil.getIntArr(sc), sc.nextInt()));
        }
    }
}