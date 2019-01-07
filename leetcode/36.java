import java.util.*;

// 120. Triangle
// Time Complexity o(n)
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty() || triangle.get(0) == null || triangle.get(0).isEmpty()) {
            return 0;
        }
        long[] dp = new long[triangle.get(triangle.size() - 1).size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        long init = get(0, 0, triangle);
        dp[0] = init;
        int l = 1;
        while (l != triangle.size()) {
            List<Integer> arr = triangle.get(l);
            long prev = dp[0];
            for (int i = 0; i < arr.size(); i++) {
                int now = arr.get(i);
                long tmp = dp[i];
                if (i > 0) {
                    dp[i] = Math.min(prev + now, dp[i] + now);
                } else {
                    dp[i] = dp[i] + now;
                }
                prev = tmp;
            }
            l++;
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(l - 1).size(); i++) {
            min = Math.min(min, dp[i]);
        }
        return (int) min;
    }

    public long get(int i, int j, List<List<Integer>> triangle) {
        if (j < 0 || j >= triangle.get(i).size()) {
            return Integer.MAX_VALUE;
        }
        return triangle.get(i).get(j);
    }

    // case ( 42 / 43) 超时
    // int min = Integer.MAX_VALUE;

    // public int minimumTotal(List<List<Integer>> triangle) {
    // if (triangle == null || triangle.isEmpty() || triangle.get(0) == null ||
    // triangle.get(0).isEmpty()) {
    // return 0;
    // }
    // min = Integer.MAX_VALUE;
    // dfs(0, 0, triangle, 0);
    // return min;
    // }

    // public void dfs(int i, int j, List<List<Integer>> triangle, int sum) {
    // if (j < 0 || j >= triangle.get(i).size()) {
    // return;
    // }
    // if (i == triangle.size() - 1) {
    // min = Math.min(min, sum + get(i, j, triangle));
    // return;
    // }
    // dfs(i + 1, j, triangle, sum + get(i, j, triangle));
    // dfs(i + 1, j + 1, triangle, sum + get(i, j, triangle));
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int k = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> triangle = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int[] tmp = StringUtil.getIntArr(sc);
                List<Integer> arr = new ArrayList<>();
                for (int var : tmp) {
                    arr.add(var);
                }
                triangle.add(arr);
            }
            int ans = s.minimumTotal(triangle);
            System.out.println(ans);

        }
    }
}