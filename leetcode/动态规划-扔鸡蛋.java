import java.util.*;

/**
 * 
 * 887. Super Egg Drop
 * https://leetcode.com/problems/super-egg-drop/
 * 
 * 参考：https://juejin.im/post/5c0ca086518825428c570079
 * 扔鸡蛋
 * 
 */
public class Solution {

    // 假设总共k个鸡蛋，n层会碎，假设第一个鸡蛋在第i层扔
    // 1. 碎掉，剩余k-1个鸡蛋试i-1层
    // 2. 没碎，剩余情况等价于k个鸡蛋试n-i层
    // i = [1, n-1]
    // f[k][n] = 1 + Max(f[k-1][i-1],f[k][n-i]);
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = j;
            }
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                for (int c = 1; c < j; c++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][c - 1], dp[i][j - c]));
                }
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.superEggDrop(sc.nextInt(), sc.nextInt()));
        }
    }
}