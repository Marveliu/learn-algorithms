import java.util.*;

// 59. Spiral Matrix II
// 思路：模拟

// [ 1, 2, 3 ]
// [ 8, 9, 4 ]
// [ 7, 6, 5 ]

// [ 1,   2,  3, 4]
// [ 12, 13, 14, 5]
// [ 11, 16, 15, 6]
// [ 10,  9,  8, 7]
public class Solution {

    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        int index = 1;
        int x = 0;
        int y = 0;
        int xmin = 0;
        int ymin = 0;
        int xmax = n - 1;
        int ymax = n - 1;
        // 移动的方向
        int type = 0;

        while (!(xmin > xmax || ymin > ymax)) {
            switch (type) {
            case 0: {
                while (y <= ymax) {
                    ans[x][y] = index++;
                    y++;
                }
                xmin++;
                x = xmin;
                y--;
                break;
            }
            case 1: {
                while (x <= xmax) {
                    ans[x][y] = index++;
                    x++;
                }
                ymax--;
                y = ymax;
                x--;
                break;
            }
            case 2: {
                while (y >= ymin) {
                    ans[x][y] = index++;
                    y--;
                }
                xmax--;
                y++;
                x = xmax;
                break;
            }
            case 3: {
                while (x >= xmin) {
                    ans[x][y] = index++;
                    x--;
                }
                ymin++;
                x++;
                y = ymin;
                break;
            }
            }
            type = (type + 1) % 4;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            int[][] ans = s.generateMatrix(n);
            for (int[] var : ans) {
                System.out.println(Arrays.toString(var));
            }
        }
    }
}