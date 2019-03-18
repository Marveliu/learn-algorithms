import java.util.*;

/**
 * 718. Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * 
 * 参考：https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
 * 思路：动态规划
 * 
 * do[i][j] 表示A序列中到i,B序列中到j,并且A[i] == B[j]的序列长度
 * dp[i][j] = dp[i-1][j-1] + 1 
 *   3 1 2
 * 1 0 1 0
 * 2 0 0 2
 * 2 0 0 1
 */
public class Solution {

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    ans = Math.max(dp[i + 1][j + 1], ans);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.findLength(StringUtil.getIntArr(sc), StringUtil.getIntArr(sc)));
        }
    }
}

// 1,2,3,2,1
// 3,2,1,4,7