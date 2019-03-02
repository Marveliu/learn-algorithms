import java.util.*;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * 1表示添加了障碍
 * 
 * 动态规划
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;
        int xlen = obstacleGrid.length;
        int ylen = obstacleGrid[0].length;
        int[][] dp = new int[xlen + 1][ylen + 1];

        if (xlen >= 1) {
            dp[1][0] = 1;
        } else if (ylen >= 1) {
            dp[0][1] = 1;
        }

        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (obstacleGrid[i][j] > 0) {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }

        return dp[xlen][ylen];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int x = sc.nextInt();
            sc.nextLine();
            int y = sc.nextInt();
            sc.nextLine();
            int[][] obstacleGrid = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    obstacleGrid[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
        }
    }
}