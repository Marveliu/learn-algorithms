import java.util.*;

// 81. Search in Rotated Sorted Array II
// 思路：dfs
public class Solution {

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length)
            return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length)
            return false;
        if (board[y][x] != word[i])
            return false;
        // 两次xor对值不影响，用于标记visit
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1) || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1) || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        char A = 'a';
        A ^= 256;
        System.out.println(A);
        A ^= 256;
        System.out.println(A);

        // while (true) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Input>>>");
        // int x = sc.nextInt();
        // sc.nextLine();
        // int y = sc.nextInt();
        // sc.nextLine();
        // char[][] board = new char[x][y];
        // for (int i = 0; i < x; i++) {
        // String[] tmp = StringUtil.nextLineFilter(sc).split(",");
        // for (int j = 0; j < y; j++) {
        // board[i][j] = tmp[j].charAt(0);
        // }
        // }
        // String word = sc.nextLine();
        // System.out.println(s.exist(board, word));
        // }
    }
}

// 3
// 4
// [A,B,C,E]
// [S,F,C,S]
// [A,D,E,E]

// Input>>>
// 3
// 4
// [A,B,C,E]
// [S,F,C,S]
// [A,D,E,E]
// ABCCED
// true
// Input>>>
// 3
// 4
// [A,B,C,E]
// [S,F,C,S]
// [A,D,E,E]
// SEE
// true
// Input>>>
// 3
// 4
// [A,B,C,E]
// [S,F,C,S]
// [A,D,E,E]
// ABCB
// false