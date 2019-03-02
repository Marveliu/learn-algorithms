import java.util.*;
/**
 * 74. Search a 2D Matrix
 * 思路：从左下角进行二分查找
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int xl = matrix.length;
        int yl = matrix[0].length;
        for (int i = xl - 1; i >= 0; i--) {
            for (int j = 0; j < yl; j++) {
                int now = matrix[i][j];
                if (now == target) {
                    return true;
                } else if (now > target) {
                    // i--；
                    break;
                } else {
                    // j++
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int m = sc.nextInt();
            sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                String[] line = sc.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.valueOf(line[j]);
                }
            }
            int target = sc.nextInt();
            System.out.println(s.searchMatrix(matrix, target));
        }
    }
}

// 3
// 4
// 1,3,5,7
// 10,11,16,20
// 23,30,34,50
