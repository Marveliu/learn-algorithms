import java.util.*;

// 64. Minimum Path Sum
// 思路:dp
public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int xlen = grid.length;
        int ylen = grid[0].length;
        int[][] dp = new int[xlen + 1][ylen + 1];

        // init Integer.max;
        for (int i = 0; i <= ylen; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= xlen; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[1][0] = 0;

        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                dp[i + 1][j + 1] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
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
            int[][] grid = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    grid[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            System.out.println(s.minPathSum(grid));
        }
    }
}