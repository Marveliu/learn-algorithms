import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = null;

    public static int maximalSquare(char[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0)
            return 0;
        int[] height = new int[m[0].length];
        for (int i = 0; i < m[0].length; i++) {
            if (m[0][i] == '1')
                height[i] = 1;
        }
        int result = getMaxSquareArea(height);
        for (int i = 1; i < m.length; i++) {
            // 获得每一层的高度
            getHeight(m, height, i);
            // 计算每一层高度对应的最大面积
            result = Math.max(result, getMaxSquareArea(height));
        }
        return result;
    }

    public static void getHeight(char[][] m, int[] height, int idx) {
        for (int i = 0; i < m[0].length; i++) {
            if (m[idx][i] == '1')
                height[i] += 1;
            else
                height[i] = 0;
        }
    }

    public static int getMaxSquareArea(int[] hs) {
        if ((hs == null) || hs.length == 0)
            return 0;
        int len = hs.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        // 单调栈
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : hs[i]);
            if (s.isEmpty() || h >= hs[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                // 获得矩阵中最大的正方形进行比较
                maxArea = Math.max(maxArea, getSquareArea(hs[tp], s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static int getSquareArea(int h, int l) {
        int min = Math.min(h, l);
        return min * min;
    }

    public static void main(String[] args) {
        while (sc.hasNext()) {
            int row = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();
            int col = line.length();
            char[][] m = new char[row][col];
            m[0] = line.toCharArray();
            for (int i = 1; i < row; i++) {
                m[i] = sc.nextLine().toCharArray();
            }
            System.out.println(maximalSquare(m));
        }
    }

    static {
        try {
            // local test
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("testCases.txt"));
            sc = new Scanner(in);
        } catch (Exception e) {
            sc = new Scanner(System.in);
        }
    }

}
