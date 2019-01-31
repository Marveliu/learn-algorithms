import java.util.*;


// 85. Maximal Rectangle
// 84. Largest Rectangle in Histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/ 此题变种 参考 https://www.cnblogs.com/yrbbest/p/4437139.html
// https://leetcode.com/problems/maximal-rectangle/discuss/29055/My-java-solution-based-on-Maximum-Rectangle-in-Histogram-with-explanation
public class Solution {

    // dp[i][j] 表示以（i,j）坐标为右下角顶点的最大矩形
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1')
                height[i] = 1;
        }
        int result = largestRectangleArea(height);

        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            result = Math.max(result, largestRectangleArea(height));
        }

        return result;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '1')
                height[i] += 1;
            else
                height[i] = 0;
        }
    }

    // https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
    public int largestRectangleArea(int[] heights) {
        if ((heights == null) || heights.length == 0)
            return 0;
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            // 防止整个数组为递增，无法进行pop计算
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                // 当栈为空或者当前元素比栈顶元素大时，把当前元素入栈。否则把栈顶元素出栈，继续比较下一个栈顶元素与当前元素的大小。
                // 假如是1,2,3,4,1的话，运行到第2个1的时候，就要先出栈4，计算4 x 1，再是 3 x 2， 2 x 3，之后1 入栈， 最后遇到0计算 1 x
                // 4。
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            // int[] height = StringUtil.getIntArr(sc);
            // int ans = s.largestRectangleArea(height);
            // System.out.println(ans);
            int x = sc.nextInt();
            sc.nextLine();
            int y = sc.nextInt();
            sc.nextLine();
            char[][] m = new char[x][y];
            for (int i = 0; i < x; i++) {
                String line = StringUtil.nextLineFilter(sc);
                String[] ss = line.split(" ");
                for (int j = 0; j < ss.length; j++) {
                    m[i][j] = ss[j].toCharArray()[0];
                }
            }
            int ans = s.maximalRectangle(m);
            System.out.println(ans);
        }
    }
}

// 1 1 0 1 0 1
// 0 1 0 0 1 1
// 1 1 1 1 0 1
// 1 1 1 1 0 1


// 4
// 6
// 1 1 0 1 0 1
// 0 1 0 0 1 1
// 1 1 1 1 0 1
// 1 1 1 1 0 1
// 8

