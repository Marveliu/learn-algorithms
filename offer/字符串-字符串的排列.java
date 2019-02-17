import java.util.*;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 * input abc 
 * output abc,acb,bac,bca,cab和cba。
 * 
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
 */
public class Solution {

    ArrayList<String> res = null;
    Set<String> sets = null;

    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        sets = new HashSet<>();
        if (str == null || str.isEmpty())
            return res;
        dfs("", str, new int[str.length()]);
        return res;
    }

    public void dfs(String t, String s, int[] v) {
        if (t.length() == s.length()) {
            if(!sets.contains(t)){
                sets.add(t);
                res.add(t);
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (v[i] != 1) {
                v[i] = 1;
                dfs(t + s.charAt(i), s, v);
                v[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            for (String var : s.Permutation(sc.nextLine())) {
                System.out.println(var);
            }
        }
    }
}
// aa
// abc