import java.util.*;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 * 
 * Given a triangle, find the minimum path sum from top to bottom.
 * 
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * 
 * ans = [2 -> 3 -> 5 -> 1 = 11]
 * 思路：动态规划
 * dp[i][j] 表示 到第i层第j个元素的最小值
 * dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])
 * 取全局最小值，同时二维dp可以压缩成一维的dp
 * dp[i] = Math.min(dp[i]+n[i],dp[i+1]+n[i]) n[i] 表示遍历的当前层的第i个元素
 * 
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty() || triangle.get(0) == null || triangle.get(0).isEmpty()) {
            return 0;
        }
        long[] dp = new long[triangle.get(triangle.size() - 1).size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        long init = get(0, 0, triangle);
        dp[0] = init;
        int l = 1;
        while (l != triangle.size()) {
            List<Integer> arr = triangle.get(l);
            long prev = dp[0];
            for (int i = 0; i < arr.size(); i++) {
                int now = arr.get(i);
                long tmp = dp[i];
                if (i > 0) {
                    dp[i] = Math.min(prev + now, dp[i] + now);
                } else {
                    dp[i] = dp[i] + now;
                }
                prev = tmp;
            }
            l++;
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(l - 1).size(); i++) {
            min = Math.min(min, dp[i]);
        }
        return (int) min;
    }

    public long get(int i, int j, List<List<Integer>> triangle) {
        if (j < 0 || j >= triangle.get(i).size()) {
            return Integer.MAX_VALUE;
        }
        return triangle.get(i).get(j);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int k = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> triangle = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int[] tmp = StringUtil.getIntArr(sc);
                List<Integer> arr = new ArrayList<>();
                for (int var : tmp) {
                    arr.add(var);
                }
                triangle.add(arr);
            }
            int ans = s.minimumTotal(triangle);
            System.out.println(ans);

        }
    }
}