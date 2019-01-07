import java.util.*;

import jdk.nashorn.internal.objects.Global;

// 188. Best Time to Buy and Sell Stock IV
// 思路：动态规划
// 全局最优解 为 上一个全局最优解和最新的局部最优解的比较，寻得状态转移的规则。
public class Solution {

    /**
     * local[i][j]第i天时最多可进行j次交易并且最后一次交易在第i天卖出的最大利润,局部最优
     * global[i][j]到达第i天时最多可进行j次交易的最大利润，全局最优
     **/
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len) {
            return getProfit(prices);
        }
        int[][] l = new int[len][k + 1];
        int[][] g = new int[len][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < len; i++) {
                int diff = prices[i] - prices[i - 1];
                // 局部最优解变化的两个情况，上一个全局最优解情况+diff，以及最新的局部最优解
                l[i][j] = Math.max(g[i - 1][j - 1] + Math.max(0, diff), l[i - 1][j] + diff);
                // 全局最优解调整 最新的局部最优解和之前的全
                // 最优解的比较
                g[i][j] = Math.max(l[i][j], g[i - 1][j]);
            }
        }
        return g[len - 1][k];
    }

    public int getProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff >= 0) {
                sum += diff;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = StringUtil.getIntArr(sc);
            int k = sc.nextInt();
            int ans = s.maxProfit(k, test);
            System.out.println(ans);
        }
    }
}