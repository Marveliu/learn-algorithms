import java.util.*;

// 97. Interleaving String
// 思路：dp 备忘录模式
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }
    
    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid = 
            i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || 
            j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String s1 = StringUtil.nextLineFilter(sc);
            String s2 = StringUtil.nextLineFilter(sc);
            String s3 = StringUtil.nextLineFilter(sc);
            boolean ans = s.isInterleave(s1, s2, s3);
            System.out.println(ans);
        }
    }
}
// "aabcc"
// "dbbca"
// "aadbbcbcac"

// "aabcc"
// "dbbca"
// "aadbbbaccc"
