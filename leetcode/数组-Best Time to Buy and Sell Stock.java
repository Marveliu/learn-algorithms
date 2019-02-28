import java.util.*;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * 思路：
 * 将股票售卖看成上下坡，即求上坡最大的高度，维护最大值
 * 找到最低谷，和最高峰
 * 如果出现了最低谷，那么之后的比较都是和最低谷的
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int tmp = prices[i] - min;
            max = (tmp >= max ? tmp : max);
        }
        return max;
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