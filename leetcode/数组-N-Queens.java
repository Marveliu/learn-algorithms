import java.util.*;

/**
 * N-Queens
 * 
 * https://leetcode.com/problems/n-queens/
 * 
 * 八皇后问题，dfs+回溯
 * 时间复杂度：o(n^2)
 */
public class Solution {

    List<List<String>> ans = null;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            int[][] v = new int[n][n];
            v[0][i] = 1;
            list.add(convert(i, n));
            dfs(list, 1, n, v);
        }
        return ans;
    }

    public void dfs(List<String> list, int level, int n, int[][] v) {
        if (level >= n) {
            ans.add(list);
            return;
        }
        // check
        for (int i = 0; i < n; i++) {
            if (check(v, level, i)) {
                List<String> nl = new ArrayList<>(list);
                nl.add(convert(i, n));
                v[level][i] = 1;
                dfs(nl, level + 1, n, v);
                v[level][i] = 0;
            }
        }
        return;
    }

    public String convert(int target, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != target) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
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
        int[][] test = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        System.out.println(s.check(test, 2, 1));
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            for (List<String> var : s.solveNQueens(n)) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}

// 3
// 1 0 0
// 0 0 1
// * * *