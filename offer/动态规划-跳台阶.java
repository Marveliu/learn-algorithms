import java.util.*;

/**
 * 跳台阶
 * 动态规划-斐波那契
 * 
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 */
public class Solution {

    // dfs
    // public int JumpFloor(int target) {
    //     if (target == 2) {
    //         return 2;
    //     }
    //     if (target == 1) {
    //         return 1;
    //     }
    //     if (target <= 0) {
    //         return 0;
    //     }
    //     return JumpFloor(target - 1) + JumpFloor(target - 2);
    // }

    // dp
    public int JumpFloor(int target) {
        int[] dp = new int[Math.max(3, target + 1)];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.JumpFloor(sc.nextInt()));
        }
    }
}