import java.util.*;

// 73. Set Matrix Zeroes
// 思路：模拟
// Time Complexity: o(n^2)
// Space Complexity: o(n)
public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int xl = matrix.length;
        int yl = matrix[0].length;
        boolean[][] visit = new boolean[xl][yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (visit[i][j])
                    continue;
                if (matrix[i][j] == 0) {
                    setZeroesRow(matrix, visit, i);
                    setZeroesCol(matrix, visit, j);
                }
            }
        }
    }

    public void setZeroesRow(int[][] matrix, boolean[][] v, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!v[row][i] && matrix[row][i] != 0) {
                v[row][i] = true;
                matrix[row][i] = 0;
            }
        }
    }

    public void setZeroesCol(int[][] matrix, boolean[][] v, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (!v[i][col] && matrix[i][col] != 0) {
                v[i][col] = true;
                matrix[i][col] = 0;
            }
        }
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
                int[] tmp = StringUtil.getIntArr(sc);
                matrix[i] = tmp;
            }
            s.setZeroes(matrix);
            for (int[] tmp : matrix) {
                System.out.println(Arrays.toString(tmp));
            }
        }
    }
}
