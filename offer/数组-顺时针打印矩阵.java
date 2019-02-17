import java.util.*;

/**
 * 顺时针打印矩阵
 * 思路：dfs
 * 
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a
 */
public class Solution {

    // 1. 条件判断
    // public ArrayList<Integer> printMatrix(int[][] matrix) {
    //     ArrayList<Integer> arr = new ArrayList<Integer>();
    //     int x_len = matrix.length;
    //     if (x_len == 0)
    //         return arr;
    //     int y_len = matrix[0].length;

    //     int x = 0;
    //     int y = 0;
    //     // 方向
    //     int next = 0;
    //     int x_min = 0;
    //     int x_max = x_len - 1;
    //     int y_min = 0;
    //     int y_max = y_len - 1;
    //     while (true) {
    //         if (x_min > x_max || y_min > y_max) {
    //             break;
    //         }
    //         arr.add(matrix[x][y]);
    //         switch (next) {
    //         case 0: {
    //             y++;
    //             if (y > y_max) {
    //                 x_min++;
    //                 y = y_max;
    //                 x = x_min;
    //                 next = 1;
    //             }
    //             break;
    //         }
    //         case 1: {
    //             x++;
    //             if (x > x_max) {
    //                 y_max--;
    //                 x = x_max;
    //                 y = y_max;
    //                 next = 2;
    //             }
    //             break;
    //         }
    //         case 2: {
    //             y--;
    //             if (y < y_min) {
    //                 x_max--;
    //                 y = y_min;
    //                 x = x_max;
    //                 next = 3;
    //             }
    //             break;
    //         }
    //         case 3: {
    //             x--;
    //             if (x < x_min) {
    //                 y_min++;
    //                 x = x_min;
    //                 y = y_min;
    //                 next = 0;
    //             }
    //             break;
    //         }
    //         }
    //     }
    //     return arr;
    // }

    // 2. 读外围，进行递归 dfs
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int xs = 0;
        int xe = matrix.length - 1;
        int ys = 0;
        int ye = matrix[0].length - 1;
        print(arr, matrix, xs, xe, ys, ye);
        return arr;
    }

    public void print(ArrayList<Integer> arr, int[][] m, int xs, int xe, int ys, int ye) {
        if (xs > xe || ys > ye) {
            return;
        }
        int x = xs;
        int y = ys;
        if (xs == xe) {
            for (; y <= ye; y++) {
                arr.add(m[x][y]);
            }
        } else if (ys == ye) {
            for (; x <= xe; x++) {
                arr.add(m[x][y]);
            }
        } else {
            for (; y < ye; y++) {
                arr.add(m[x][y]);
            }
            for (; x < xe; x++) {
                arr.add(m[x][y]);
            }
            for (; y > ys; y--) {
                arr.add(m[x][y]);
            }
            for (; x > xs; x--) {
                arr.add(m[x][y]);
            }
        }
        print(arr, m, xs + 1, xe - 1, ys + 1, ye - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[][] m = { { 1, 2, 3 }, { 4, 5, 6 } };
        // int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,15,
        // 16 } };
        int[][] m = { { 1, 2, 3, 4, 5 } };
        // int[][] m = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
        LogUtil.log(s.printMatrix(m));

    }
}