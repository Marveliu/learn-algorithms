import java.util.*;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * 最多交易两次
 * 
 * 思路：动态规划
 * https://juejin.im/post/5a3b7bbf6fb9a045204c64b6
 * 
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // left[i]:表示从第一天到第i天进行一次交易最大的收益
        int[] left = new int[prices.length];
        // right[i]:表示从第i天到最后一天进行一次交易最大的收益 
        int[] right = new int[prices.length];

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(left[i] + right[i], profit);
        }
        return profit;
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

// 4,5,2,6,3,7,3,8