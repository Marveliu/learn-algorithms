import java.util.*;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 * 
 * 思路：逐层进行旋转
 * 
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 * (0,0) -> (0,2)
 * (0,2) -> (2,2)
 * (2,2) -> (2,0)
 * (2,0) -> (0,0)
 */
public class Solution {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int xmin = 0;
        int xmax = matrix.length - 1;
        int ymin = 0;
        int ymax = matrix[0].length - 1;
        while (!(xmin >= xmax || ymin >= ymax)) {
            rotate(matrix, xmin, xmax, ymin, ymax);
            xmin++;
            xmax--;
            ymin++;
            ymax--;
        }
    }

    public void rotate(int[][] matrix, int xmin, int xmax, int ymin, int ymax) {
        int x = xmin;
        int y = ymin;
        while (y < ymax) {

            int c = matrix[x][y];
            int t = 0;
            int offest = y - ymin;

            // 1
            t = matrix[xmin + offest][ymax];
            matrix[xmin + offest][ymax] = c;
            c = t;

            // 2
            t = matrix[xmax][ymax - offest];
            matrix[xmax][ymax - offest] = c;
            c = t;

            // 3
            t = matrix[xmax - offest][ymin];
            matrix[xmax - offest][ymin] = c;
            c = t;

            // 4
            matrix[x][y] = c;
            y++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            sc.nextLine();
            int m = sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            s.rotate(matrix);
            for (int[] var : matrix) {
                System.out.println(Arrays.toString(var));
            }
        }
    }
}

// 3
// 3
// 1 2 3
// 4 5 6
// 7 8 9
// [7, 4, 1]
// [8, 5, 2]
// [9, 6, 3]