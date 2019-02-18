import java.util.*;

/**
 * 矩阵中的路径 
 * 
 * 3 * 4 是否存在bcced 
 * a b c e 
 * s f c s 
 * a d e e
 * 
 * 思路:dfs + 回溯
 * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc
 * 
 */
public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || str.length == 0)
            return true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int p = i * cols + j;
                if (matrix[p] == str[0]) {
                    if (hasPath(matrix, rows, cols, str, 0, i, j)) {
                        return true;
                    }
                }
                System.out.print(matrix[p]);
            }
            System.out.println();
        }
        return false;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str, int index, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || index >= str.length )
            return false;
        int p = x * cols + y;
        char tmp = matrix[p];
        if (tmp == '#')
            return false;
        if (tmp == str[index]) {
            if (index == str.length - 1)
                return true;
            matrix[p] = '#';
            index++;
            boolean res = hasPath(matrix, rows, cols, str, index, x + 1, y)
                    || hasPath(matrix, rows, cols, str, index, x, y + 1)
                    || hasPath(matrix, rows, cols, str, index, x - 1, y)
                    || hasPath(matrix, rows, cols, str, index, x, y - 1);
            matrix[p] = tmp;
            return res;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            String test = sc.nextLine();
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean ans = s.hasPath(in.toCharArray(), row, col, test.toCharArray());
            System.out.println(ans);
        }
    }
}

// abcesfcsadee
// abc
// 3
// 4
