import java.util.*;

/**
 * 494. Target Sum
 * 
 * https://leetcode.com/problems/target-sum/
 * 
 * 
 * 1. dfs 396ms
 * 2. dp dp[i][j]， j表示可能构成的值，i表示新增的nums[i]
 * 参考：https://www.youtube.com/watch?v=r6Wz4W1TbuI
 * 
 */
class Solution {



    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        int len = nums.length;
        for (int v : nums) {
            sum += v;
        }
        if (S > sum || S < -sum)
            return 0;
        int count = 2 * sum + 1;
        int[][] dp = new int[len + 1][count];
        dp[0][0 + sum] = 1;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            for (int j = -sum; j <= sum; j++) {
                int left = (j - cur < -sum ? 0 : dp[i][j - cur + sum]);
                int right = (j + cur > sum ? 0 : dp[i][j + cur + sum]);
                dp[i + 1][j + sum] = left + right;
            }
        }
        return dp[len][S + sum];
    }

    // dfs(o(n^2))
    // int ans = 0;
    // public int findTargetSumWays(int[] nums, int S) {
    //     ans = 0;
    //     dfs(nums, 0, 0, S);
    //     return ans;
    // }

    // public void dfs(int[] nums, int i, int sum, int s) {
    //     if (i < nums.length) {
    //         int cur = nums[i];
    //         dfs(nums, i + 1, sum + cur, s);
    //         dfs(nums, i + 1, sum - cur, s);
    //     } else {
    //         if (sum == s) {
    //             ans++;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            int S = sc.nextInt();
            System.out.println(s.findTargetSumWays(nums,S));
            sc.nextLine();
        }
    }

}