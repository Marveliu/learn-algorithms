import java.util.*;

// 44. Wildcard Matching
// 字符串匹配问题
// 1. 区间动态dfs时间复杂度太高
// 2. dp一般是二维dp
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int s_len = s.length();
        int p_len = p.length();

        boolean[][] d = new boolean[s_len + 1][p_len + 1];
        d[0][0] = true;

        for (int i = 0; i < p_len; i++) {
            if (p.charAt(i) == '*')
                d[0][i + 1] = d[0][i];
        }

        for (int i = 0; i < s_len; i++) {
            for (int j = 0; j < p_len; j++) {
                if (p.charAt(j) == '?')
                    d[i + 1][j + 1] = d[i][j];
                if (p.charAt(j) == s.charAt(i))
                    d[i + 1][j + 1] = d[i][j];
                if (p.charAt(j) == '*')
                    d[i + 1][j + 1] = d[i + 1][j] || d[i][j + 1];
            }
        }

        return d[s_len][p_len];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String s1 = sc.nextLine();
            String p = sc.nextLine();
            System.out.println(s.isMatch(s1, p));
        }
    }
}