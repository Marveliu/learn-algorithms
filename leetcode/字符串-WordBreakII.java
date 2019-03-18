import java.util.*;

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 * 
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *  "cats and dog",
 *  "cat sand dog"
 * ]
 * 
 * Memoization + Backtracking
 * 
 */
public class Solution {
   
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String target = sc.nextLine();
            List<String> dictionary = Arrays.asList(sc.nextLine().replaceAll("\"", "").split(","));
            List<String> ans = s.wordBreak(target, dictionary);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}

// catsanddog
// cat,cats,and,sand,dog

// pineapplepenapple
// apple,pen,applepen,pine,pineapple

// catsandog
// cats,dog,sand,and,cat

// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
// "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"