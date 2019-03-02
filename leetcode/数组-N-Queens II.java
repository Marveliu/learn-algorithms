import java.util.*;

/**
 * 52. N-Queens II
 * https://leetcode.com/problems/n-queens-ii/
 * 
 * 
 * 思路：dfs+回溯
 */
public class Solution {

    int ans = 0;

    public int totalNQueens(int n) {
        ans = 0;
        for (int i = 0; i < n; i++) {
            int[][] v = new int[n][n];
            v[0][i] = 1;
            dfs(1, n, v);
        }
        return ans;
    }

    public void dfs(int level, int n, int[][] v) {
        if (level >= n) {
            ans++;
            return;
        }
        // check
        for (int i = 0; i < n; i++) {
            if (check(v, level, i)) {
                v[level][i] = 1;
                dfs(level + 1, n, v);
                v[level][i] = 0;
            }
        }
        return;
    }

    public boolean check(int[][] v, int level, int target) {
        for (int i = 1; i <= level; i++) {
            int lt = target - i;
            int rt = target + i;
            int lev = level - i;
            if (v[lev][target] != 1 && (lt < 0 || v[lev][lt] != 1) && (rt >= v.length || v[lev][rt] != 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            System.out.println(s.totalNQueens(n));
        }
    }
}