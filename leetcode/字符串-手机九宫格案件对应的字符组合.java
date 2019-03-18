import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * 思路：dfs尾递归
 * 
 */
public class Solution {

    String[][] map = { { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" }, { "m", "n", "o" },
            { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" }, };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        if (digits.length() == 1) {
            return Arrays.asList(map[digits.charAt(0) - '2']);
        }
        List<String> ret = letterCombinations(digits.substring(0, digits.length() - 1));
        List<String> ans = new ArrayList<>();
        for (String var : map[digits.charAt(digits.length() - 1) - '2']) {
            for (String s : ret) {
                ans.add(s + var);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(Arrays.toString(s.letterCombinations(sc.nextLine()).toArray()));
        }
    }
}