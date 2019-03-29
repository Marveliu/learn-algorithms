import java.util.*;

/**
 * 152. Maximum Product Subarray
 * 
 * https://leetcode.com/problems/maximum-product-subarray/submissions/
 * 
 * 
 * 思路：类似数组中求得连续子串最大和，当时只需要维护历史最大值，和当前最大值，反复计算
 * 但是，在最大乘积的情况下，最大值可能有：
 * 1. 当前值 
 * 2. 历史最大值*当前值 正正
 * 3. 历史最小值*当前值 负负得正
 */
public class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            int nextMax = max * nums[i];
            int nextMin = min * nums[i];
            max = Math.max(nums[i], Math.max(nextMax, nextMin));
            min = Math.min(nums[i], Math.min(nextMax, nextMin));
            ans = Math.max(max, ans);
        }
        return ans;
    }

    // 暴力解法 o(n^2)
    // public int maxProduct(int[] nums) {
    //     if (nums == null || nums.length == 0)
    //         return 0;
    //     int len = nums.length;
    //     int ans = Integer.MIN_VALUE;
    //     for (int i = 0; i < len; i++) {
    //         int cur = 1;
    //         for (int j = i; j < len; j++) {
    //             cur = nums[j] * cur;
    //             ans = Math.max(ans, cur);
    //             if (nums[i] == 0)
    //                 break;
    //         }
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.maxProduct(StringUtil.getIntArr(sc)));
        }
    }
}

// 2,3,-2,4,-1