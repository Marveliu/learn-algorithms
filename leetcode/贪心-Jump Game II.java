import java.util.*;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * 思路：贪心算法
 */
public class Solution {

    // greedy o(n)
    // https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    // dp 时间复杂度略高
    // public int jump(int[] A) {
    //     // dp[i]表示到i的最小步数
    //     int[] dp = new int[A.length];
    //     for (int i = 0; i < dp.length; i++) {
    //         dp[i] = Integer.MAX_VALUE;
    //     }
    //     dp[0] = 0;

    //     for (int i = 0; i < A.length; i++) {
    //         int mj = A[i];
    //         for (int j = 0; j <= mj; j++) {
    //             if (i + j < A.length) {
    //                 dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
    //             } else {
    //                 return dp[A.length - 1];
    //             }
    //         }
    //     }
    //     return dp[A.length - 1];
    // }



    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.jump(StringUtil.getIntArr(sc)));
        }
    }
}