import java.util.*;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * 旋转数组
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;

        int index = 1;
        int x = 0;
        int y = 0;
        int xmin = 0;
        int ymin = 0;
        int xmax = matrix.length - 1;
        int ymax = matrix[0].length - 1;
        int type = 0;
        while (!(xmin > xmax || ymin > ymax)) {
            switch (type) {
            case 0: {
                while (y <= ymax) {
                    ans.add(matrix[x][y]);
                    y++;
                }
                xmin++;
                x = xmin;
                y--;
                break;
            }
            case 1: {
                while (x <= xmax) {
                    ans.add(matrix[x][y]);
                    x++;
                }
                ymax--;
                y = ymax;
                x--;
                break;
            }
            case 2: {
                while (y >= ymin) {
                    ans.add(matrix[x][y]);
                    y--;
                }
                xmax--;
                y++;
                x = xmax;
                break;
            }
            case 3: {
                while (x >= xmin) {
                    ans.add(matrix[x][y]);
                    x--;
                }
                ymin++;
                x++;
                y = ymin;
                break;
            }
            }
            type = (type + 1) % 4;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int x = sc.nextInt();
            sc.nextLine();
            int y = sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrix[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            System.out.println(Arrays.toString(s.spiralOrder(matrix).toArray()));
        }
    }
}