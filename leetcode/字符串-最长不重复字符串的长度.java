import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * 最长不重复字符串的长度
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 */
public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] cs = new int[256];
        int ans = 0;
        // j,i 分别表示字符串的首尾
        for (int i = 0, j = 0; i < len; i++) {
            char cur = s.charAt(i);
            cs[cur]++;
            // 直到不重复
            while (cs[cur] > 1) {
                cs[s.charAt(j++)]--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null || s.isEmpty())
    //         return 0;
    //     int len = s.length();
    //     int ans = 0;
    //     Set<Character> sets = new HashSet<>();
    //     for (int i = len - 1; i >= 0; i--) {
    //         sets.clear();
    //         for (int j = i; j < len; j++) {
    //             if (!sets.contains(s.charAt(j))) {
    //                 ans = Math.max(ans, j - i + 1);
    //                 sets.add(s.charAt(j));
    //             } else {
    //                 break;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.lengthOfLongestSubstring(sc.nextLine()));
        }
    }
}