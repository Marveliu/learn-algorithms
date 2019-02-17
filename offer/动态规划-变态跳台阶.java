import java.util.*;

/**
 * 变态跳台阶
 * 动态规划-斐波那契
 * 
 * 思路:
 * 从第3个台阶跳到第5个台阶，间隔2个台阶，相当与从开始跳到两个台阶
 * dp[i] = dp[i] + dp[i - j];
 * 
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387
 */
public class Solution {

    // 1. dfs
    // public int JumpFloorII(int target) {
    //     int count = 0;
    //     if (target <= 1) {
    //         return 1;
    //     }
    //     for (int index = 1; index <= target; index++) {
    //         count = count + JumpFloorII(target - index);
    //     }
    //     return count;
    // }

    // 2. dp
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[i - j];
            }
            dp[i]++;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.JumpFloorII(sc.nextInt()));
        }
    }
}