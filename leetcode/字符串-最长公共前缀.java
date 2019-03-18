import java.util.*;


/**
 * 14. Longest Common Prefix
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * 找到公共的前缀字符串
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs == null || strs.length == 0)
            return ans;

        Arrays.sort(strs, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        String s = strs[0];
        int p = 0;

        boolean flag = true;
        while (p <= s.length() && flag) {
            String prefix = s.substring(0, p);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans = prefix;
            p++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String line = StringUtil.nextLineFilter(sc);
            System.out.println(s.longestCommonPrefix(line.split(",")));
        }
    }
}