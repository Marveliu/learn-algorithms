import java.util.*;

/**
 * 76. Minimum Window Substring
 * 
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * 参考：https://www.jianshu.com/p/92bec8fbe72e
 * 
 * S = "ADOBECODEBANC", T = "ABC"
 * "BANC"
 * 找到S中报站T的最小子串
 * 
 * 思路：使用滑动窗口
 * 
 */
public class Solution {

    public String minWindow(String s, String t) {
        int[] sCnt = new int[255];
        int[] tCnt = new int[255];

        for (int i = 0; i < t.length(); i++) {
            tCnt[t.charAt(i)]++;
        }

        int start = 0;
        int begin = -1;
        int end = s.length();
        int found = 0;
        int minLen = s.length();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            sCnt[c1]++;
            // 如果算上这个字符后，数量不超过t中这个字符的数量，那么这个字符算是valid(即找到一个匹配的字符)；
            if (sCnt[c1] <= tCnt[c1])
                found++;
            // 找到一个valid的字符串。
            if (found == t.length()) {
                // 这个字符串end一定是i。现在需要找到这个字符串的起始位置。起始位置那个字符在s中出现的次数一定和在t中出现的次数一样多；
                // 所有那些s中出现次数比t中多的，一定是多余的，从前往后扫，然后全部删掉。 记得每次从s中删掉的时候，s对这个字符的cnt也要减一。
                while (start < i && sCnt[s.charAt(start)] > tCnt[s.charAt(start)]) {
                    sCnt[s.charAt(start)]--;
                    start++;
                }
                // 更新minLen，如果更新了，那么记录下这个长度的起始点和终点。
                if (i - start < minLen) {
                    minLen = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的start跳过，注意sCnt也要减一，继续扫。
                sCnt[s.charAt(start)]--;
                start++;
                found--;
            }
        }
        return begin == -1 ? "" : s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String st = sc.nextLine();
            String tt = sc.nextLine();
            System.out.println(s.minWindow(st, tt));
        }
    }
}