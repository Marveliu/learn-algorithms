import java.util.*;

// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子

public class Solution {
    
    public int movingCount(int threshold, int rows, int cols) {
        int[][] visit = new int[rows][cols];
        dp(threshold, rows, cols, 0, 0, visit);
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visit[i][j] == 1)
                    ans++;
                System.out.print(visit[i][j]);
            }
            System.out.println();
        }
        return ans;
    }

    public void dp(int threshold, int rows, int cols, int x, int y, int[][] visit) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || visit[x][y] == 1) {
            return;
        }
        if (cal(x, y) <= threshold) {
            visit[x][y] = 1;
            dp(threshold, rows, cols, x + 1, y, visit);
            dp(threshold, rows, cols, x - 1, y, visit);
            dp(threshold, rows, cols, x, y + 1, visit);
            dp(threshold, rows, cols, x, y - 1, visit);
        }
    }

    public int cal(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        while (y != 0) {
            sum = sum + y % 10;
            y = y / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int threshold = sc.nextInt();
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int ans = s.movingCount(threshold, rows, cols);
            System.out.println(ans);
        }
    }
}