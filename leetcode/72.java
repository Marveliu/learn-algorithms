import java.util.*;

// 76. Minimum Window Substring
// 参考：https://www.jianshu.com/p/92bec8fbe72e
public class Solution {


    public String minWindow(String s, String t) {
        int[] sCnt = new int[255];
        int[] tCnt = new int[255];
        
        for (int i=0; i<t.length(); i++) {
            tCnt[t.charAt(i)]++;
        }
        
        int start = 0;
        int begin = -1, end = s.length();
        int found = 0, minLen = s.length();
        
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            sCnt[c1]++;
            /** 如果算上这个字符后，数量不超过t中这个字符的数量，那么这个字符算是valid(即找到一个匹配的字符)；
             */
            if(sCnt[c1] <= tCnt[c1])    found++;
            /** 找到一个valid的字符串。
             */
            if(found == t.length()) {
                /** 这个字符串end一定是i。现在需要找到这个字符串的起始位置。
                 * 起始位置那个字符在s中出现的次数一定和在t中出现的次数一样多；
                 * 所有那些s中出现次数比t中多的，一定是多余的，从前往后扫，然后全部删掉。
                 * 记得每次从s中散掉的时候，s对这个字符的cnt也要减一。
                 */ 
                while (start<i && sCnt[s.charAt(start)]>tCnt[s.charAt(start)]) {
                    sCnt[s.charAt(start)]--;
                    start++;
                }
                /** 更新minLen，如果更新了，那么记录下这个长度的起始点和终点。 
                 */
                if(i-start < minLen) {
                    minLen = i-start;
                    begin = start;
                    end = i;
                }
                
                /** 把开头的start跳过，注意sCnt也要减一，继续扫。
                 */ 
                sCnt[s.charAt(start)]--;
                start++;
                found--;
            }
        }
        return begin == -1 ? "" : s.substring(begin, end+1);
    }

    // String ans = null;

    // public String minWindow(String s, String t) {
    //     ans = null;
    //     return dfs(s, t);
    // }

    // public String dfs(String s, String t) {
    //     if (s.length() < t.length())
    //         return "";
    //     if (s.length() == t.length()) {
    //         return check(s, t);
    //     }

    //     String lr = minWindow(s.substring(0, s.length() - 1), t);
    //     String rr = minWindow(s.substring(1, s.length()), t);

    //     if (lr.isEmpty() && rr.isEmpty()) {
    //         return check(s, t);
    //     } else if (!lr.isEmpty() && !rr.isEmpty()) {
    //         return (lr.length() < rr.length()) ? lr : rr;
    //     } else {
    //         return lr.isEmpty() ? rr : lr;
    //     }
    // }

    // public String check(String s, String t) {
    //     if (ans == null) {
    //         HashMap<Character, Integer> map = new HashMap<>();
    //         for (int i = 0; i < s.length(); i++) {
    //             Integer value = map.putIfAbsent(s.charAt(i), 1);
    //             if (value != null) {
    //                 map.put(s.charAt(i), value + 1);
    //             }
    //         }
    //         for (int i = 0; i < t.length(); i++) {
    //             Integer value = map.get(t.charAt(i));
    //             if (value == null || value == 0) {
    //                 return "";
    //             }
    //             map.put(t.charAt(i), value - 1);
    //         }
    //         ans = s;
    //         return s;
    //     }
    //     return ans;
    // }

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