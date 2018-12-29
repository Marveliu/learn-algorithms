import java.util.*;

// 139 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
// dp
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String var : wordDict) {
                int j = i - var.length();
                if (j >= 0 && dp[j] && s.substring(j, i).equals(var)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String target = sc.nextLine();
            // String in = sc.nextLine();
            // in = in.replaceAll("\"", "");
            List<String> dictionary = Arrays.asList(sc.nextLine().replaceAll("\"", "").split(","));
            System.out.println(s.wordBreak(target, dictionary));
        }
    }
}