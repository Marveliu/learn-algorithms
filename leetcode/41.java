import java.util.*;

// 115. Distinct Subsequences
// 参考： https://blog.csdn.net/xygy8860/article/details/47865531
public class Solution {

    public int numDistinct(String S, String T) {
        // array creation
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        // filling the first row: with 1s
        for (int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we
        // need.
        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }
        for (int[] var : mem) {
            System.out.println(Arrays.toString(var));
        }
        return mem[T.length()][S.length()];
    }

    // dfs Time Limit Exceeded
    // int ans = 0;
    // public static HashMap<String, Integer> visit = new HashMap<>();

    // public int numDistinct(String s, String t) {
    // if (s.length() < t.length())
    // return 0;
    // visit.clear();
    // StringBuilder sb = new StringBuilder();
    // for (int i = 0; i < s.length(); i++) {
    // sb.append("0");
    // }
    // return dfs(s.toCharArray(), t.toCharArray(), sb.toString(), 0);
    // }

    // public int dfs(char[] s, char[] t, String num, int count) {
    // if (match(s, t, num, count)) {
    // visit.put(num, 1);
    // return 1;
    // }
    // if ((s.length - count) == t.length) {
    // return 0;
    // }

    // for (int i = 0; i < s.length; i++) {
    // if (num.charAt(i) == '1') {
    // continue;
    // }
    // String tmp = setVisit(num, i);
    // int value = 0;
    // if (!visit.containsKey(tmp)) {
    // value = dfs(s, t, tmp, count + 1);
    // }
    // visit.putIfAbsent(num, 0);
    // visit.put(num, value + visit.get(num));
    // }
    // return visit.get(num);
    // }

    // public String setVisit(String num, int index) {
    // char[] cs = num.toCharArray();
    // cs[index] = '1';
    // return String.valueOf(cs);
    // }

    // // num中为1的过滤
    // public boolean match(char[] s, char[] t, String num, int count) {
    // if (s.length - count != t.length) {
    // return false;
    // }
    // int index = 0;
    // for (int i = 0; i < s.length; i++) {
    // if (num.charAt(i) != '1') {
    // if (t[index] != s[i]) {
    // return false;
    // }
    // index++;
    // }
    // }
    // return true;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            // System.out.println(visit.computeIfAbsent("tet", v -> 1));
            String ss = sc.nextLine();
            String tt = sc.nextLine();
            // System.out.println(ss.substring(0, 0) + ss.substring(1, ss.length()));
            // String test = "100";
            // System.out.println(s.setVisit(test, 4));
            int ans = s.numDistinct(ss, tt);
            System.out.println(ans);
        }
    }
}

// rabbbit
// rabbit

// babgbag
// bag

// bccbcdcabadabddbccaddcbabbaaacdba
// bccbbdcbabgbag