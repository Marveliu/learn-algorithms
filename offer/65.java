import java.util.*;

// dp问题注意 char[] tmp = Arrays.copyOf(matrix, matrix.length); 以及i * cols + j 转化
public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || str.length == 0)
            return true;
        int i = 0, j = 0;
        for (; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    if (hasPath(matrix, rows, cols, str, 0, i, j)) {
                        return true;
                    }
                }
                System.out.print(matrix[i * cols + j]);
            }
            System.out.println();
        }
        return false;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str, int index, int x, int y) {
        char[] tmp = Arrays.copyOf(matrix, matrix.length);
        int p = x * cols + y;
        if (x < 0 || x >= rows || y < 0 || y >= cols || index >= str.length || tmp[p] == '#')
            return false;
        if (tmp[p] == str[index]) {
            if (index == str.length - 1)
                return true;
            tmp[p] = '#';
            index++;
            return hasPath(tmp, rows, cols, str, index, x + 1, y) || hasPath(tmp, rows, cols, str, index, x, y + 1)
                    || hasPath(tmp, rows, cols, str, index, x - 1, y) || hasPath(tmp, rows, cols, str, index, x, y - 1);
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
