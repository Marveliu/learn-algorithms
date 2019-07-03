import java.util.*;

/**
 * 221. Maximal Square
 * 
 * https://leetcode.com/problems/maximal-square/
 * 
 * 1. 单调栈 o(n^3)，类似 https://leetcode.com/problems/maximal-rectangle/
 * 2. 动态规划 o(n^2)
 */
public class Solution {

    // public int maximalSquare(char[][] matrix) {
    //     if (matrix == null || matrix.length == 0)
    //         return 0;
    //     int len = matrix[0].length;
    //     int[] counts = new int[len];
    //     int[] dp = new int[len];
    //     int ans = 0;
    //     for (char[] cs : matrix) {
    //         for (int i = 0; i < len; i++) {
    //             if (cs[i] == '1') {
    //                 counts[i]++;
    //             } else {
    //                 counts[i] = 0;
    //             }
    //         }
    //         ans = Math.max(ans, cal(counts));
    //     }
    //     return ans;
    // }

    // // 单调栈
    // public int cal(int[] counts) {
    //     int len = counts.length;
    //     int ans = 0;
    //     Stack<Integer> s = new Stack<>();
    //     for (int i = 0; i <= len; i++) {
    //         int h = (i == len ? 0 : counts[i]);
    //         if (s.isEmpty() || h >= counts[s.peek()]) {
    //             s.push(i);
    //         } else {
    //             int tp = s.pop();
    //             int hv = counts[tp];
    //             int wv = (s.isEmpty() ? i : i - 1 - s.peek());
    //             int min = Math.min(hv, wv);
    //             ans = Math.max(ans, min * min);
    //             i--;
    //         }
    //     }
    //     return ans;
    // }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int t = dp[i][j + 1];
                    int l = dp[i + 1][j];
                    int d = dp[i][j];
                    int v = Math.min(l, Math.min(t, d)) + 1;
                    dp[i + 1][j + 1] = v;
                    ans = Math.max(ans, v * v);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int h = sc.nextInt();
            int w = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[h][w];
            for (int i = 0; i < h; i++) {
                matrix[i] = sc.nextLine().toCharArray();
            }
            System.out.println(s.maximalSquare(matrix));
        }
    }
}

// 10111
// 10111
// 11111
// 10010