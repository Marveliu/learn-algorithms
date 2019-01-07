import java.util.*;

// 121. Best Time to Buy and Sell Stock
// 思路：模拟

// Time complexity O (n)
// Space complexity O (1)

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