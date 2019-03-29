import java.util.*;

/**
 * 200. Number of Islands
 * 
 * https://leetcode.com/problems/number-of-islands/
 * 
 * 题目：二维矩阵中1组成孤岛，0相当于水，求得孤岛的个数。
 * 思路：遍历二维矩阵，对未被标记的1进行dfs，标记所有可达的相邻1，每dfs一次表示发现了一次孤岛
 * 时间复杂度：o(n*m)
 * 空间复杂度：o(n*m)
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int lenx = grid.length;
        int leny = grid[0].length;
        int[][] v = new int[lenx][leny];
        int ans = 0;
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                if (v[i][j] == 1)
                    continue;
                if (grid[i][j] == '1') {
                    dfs(grid, v, i, j, lenx, leny);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int[][] v, int x, int y, int lenx, int leny) {
        if (x < 0 || x >= lenx || y < 0 || y >= leny || v[x][y] == 1 || grid[x][y] == '0') {
            return;
        }
        v[x][y] = 1;
        dfs(grid, v, x + 1, y, lenx, leny);
        dfs(grid, v, x, y + 1, lenx, leny);
        dfs(grid, v, x - 1, y, lenx, leny);
        dfs(grid, v, x, y - 1, lenx, leny);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
        }
    }
}
