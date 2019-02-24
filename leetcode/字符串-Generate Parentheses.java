import java.util.*;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * 思路:维护已经设置的"(",")"进行dfs+回溯。
 */
public class Solution {

    List<String> ans = null;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        int[] v = new int[n * 2];
        dfs(v, n, n, -1);
        return ans;
    }

    public void dfs(int[] v, int left, int right, int last) {
        if (left > right)
            return;
        if (left == 0 && right == 0) {
            ans.add(convert(v));
            return;
        }
        for (int i = last + 1; i < v.length; i++) {
            dfs(v, left - 1, right, i);
            v[i] = 1;
            dfs(v, left, right - 1, i);
            v[i] = 0;
        }
    }

    public String convert(int[] v) {
        StringBuilder sb = new StringBuilder();
        for (int var : v) {
            if (var == 0) {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(Arrays.toString(s.generateParenthesis(sc.nextInt()).toArray()));

            // String[] check = StringUtil.nextLineFilter(sc).split(",");
            // List<String> ans = s.generateParenthesis(sc.nextInt());
            // for (String var : check) {
            // if (!ans.contains(var))
            // System.out.println(var);
            // }

        }
    }
}