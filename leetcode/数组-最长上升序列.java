import java.util.*;


/**
 * 300. Longest Increasing Subsequence
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * 
 * 思路：
 * 1. dp[i]表示以i为结尾的最大序列长度，空间复杂度o(n)，遍历[0,i-1]维护最大的序列长度，时间复杂度为o(n^2)
 * 2. nlog(n) 使用tails数组进行二分查找，具体：https://segmentfault.com/a/1190000003819886
 */
public class Solution {

    // public int lengthOfLIS(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
    //     int len = nums.length;
    //     int[] dp = new int[len];
    //     Arrays.fill(dp, 1);
    //     int ans = 1;
    //     for (int i = 1; i < len; i++) {
    //         for (int j = i - 1; j >= 0; j--) {
    //             if (nums[i] > nums[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         ans = Math.max(ans, dp[i]);
    //     }
    //     return ans;
    // }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int ans = 0;
        int[] tails = new int[len];
        for (int n : nums) {
            int i = 0, j = ans;
            while (i != j) {
                int m = (i + j) >> 1;
                if (tails[m] < n) {
                    i = m + 1;
                } else {
                    j = m;
                }
                tails[i] = n;
                if (i == ans)
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            System.out.println(s.lengthOfLIS(nums));
        }
    }
}
