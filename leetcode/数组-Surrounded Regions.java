import java.util.*;


/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * 思路：
 * 有点类似，围棋。
 * 从边缘处进行dfs遍历，标记所有可以找到的‘O’为1, 表示此类节点需要进行替换
 * 
 */
public class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int m = board.length - 1;
        int n = board[0].length - 1;

        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n] == 'O') {
                dfs(board, i, n);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m][i] == 'O') {
                dfs(board, m, i);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }

    public static void main(String[] args) {
        make();
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int xl = sc.nextInt();
            int yl = sc.nextInt();
            sc.nextLine();
            char[][] test = new char[xl][yl];
            for (int i = 0; i < xl; i++) {
                String in = sc.nextLine();
                String[] tmp = in.split(" ");
                for (int j = 0; j < yl; j++) {
                    test[i][j] = tmp[j].charAt(0);
                }
            }
            System.out.println();
            s.solve(test);
            log(test);
        }
    }

    public static void make() {
        int xl = 100;
        int yl = 100;
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (i == 0 || i == 99) {
                    System.out.print('X' + " ");
                } else if (j == 0 || j == 99) {
                    System.out.print('X' + " ");
                } else {
                    System.out.print('O' + " ");
                }
            }
            System.out.println();
        }
    }

    public static void log(char[][] Input) {
        int xl = Input.length;
        int yl = Input[0].length;
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                System.out.print(Input[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 4
// 4
// X X X X
// X O O X
// X X O X
// X O X X

// X X X X
// X O O O
// X X O X
// X O X X

// X X X X
// X O O X
// X X O X
// X O O X

// X X X X
// X O O X
// X O O X
// X X X O

// 6
// 6
// O X O O X X
// O X X X O X
// X O O X O O
// X O X X X X
// O O X O X X
// X X O O O O
