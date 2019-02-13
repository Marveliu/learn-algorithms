import java.util.*;

import sun.security.util.Length;

// 45. Jump Game II
// 思路：greedy
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
    // // dp[i]表示到i的最小步数
    // int[] dp = new int[A.length];
    // for (int i = 0; i < dp.length; i++) {
    // dp[i] = Integer.MAX_VALUE;
    // }
    // dp[0] = 0;

    // for (int i = 0; i < A.length; i++) {
    // int mj = A[i];
    // for (int j = 0; j <= mj; j++) {
    // if (i + j < A.length) {
    // dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
    // } else {
    // return dp[A.length - 1];
    // }
    // }
    // }
    // return dp[A.length - 1];
    // }

    // 超时
    // public int jump(int[] A) {
    // int[] vis = new int[A.length];
    // int count = 0;

    // // 下一次可以跳的下标
    // List<Integer> jump = new ArrayList<>();
    // jump.add(0);

    // while (A.length > 1 && vis[A.length - 1] != 1) {
    // List<Integer> tmp = new ArrayList<>();
    // for (int i = 0; i < jump.size(); i++) {
    // int jindex = jump.get(i);
    // if (vis[jindex] == 1)
    // continue;
    // int mjindex = jindex + A[jindex];
    // if (mjindex >= A.length - 1)
    // return count + 1;
    // vis[jindex] = 1;
    // for (int j = 0; j <= A[jindex]; j++) {
    // tmp.add(jindex + j);
    // }
    // }
    // jump = tmp;
    // count++;
    // }
    // return count;
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