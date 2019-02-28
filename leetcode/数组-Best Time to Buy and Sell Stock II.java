import java.util.*;

/**
 * 122. Best Time to Buy and Sell Stock II
 * 可以任意交易
 * 
 * 思路: 动态规划
 * 时间复杂度：o(n)
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int now = prices[i];
            dp[i] = dp[i - 1] + Math.max(now - prices[i - 1], 0);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = StringUtil.getIntArr(sc);
            int ans = s.maxProfit(test);
            System.out.println(ans);
        }
    }
}