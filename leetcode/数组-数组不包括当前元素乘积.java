import java.util.*;

/**
 * 238. Product of Array Except Self
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * 思路：其实就是一个二维举证，不算对角线上的值，分别计算上三角和下三角即可
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        int n = 1;
        for (int i = 1; i < len; i++) {
            n = n * nums[i - 1];
            ans[i] = n;
        }
        n = 1;
        for (int i = len - 2; i >= 0; i--) {
            n = n * nums[i + 1];
            ans[i] = ans[i] * n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            System.out.println(Arrays.toString(s.productExceptSelf(StringUtil.getIntArr(sc))));
        }
    }
}