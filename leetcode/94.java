import java.util.*;

public class Solution {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sum = Math.max(sum + n, n);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.maxSubArray(StringUtil.getIntArr(sc)));
        }
    }
}