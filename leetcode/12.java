import java.util.*;

// 140. Word Break II
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences

// dfs 动态规划
public class Solution {

    // 超时，应该使用尾迭代的方式，可以减少计算量，子问题->大问题，而不是大问题->子问题
    // ArrayList<String> ans = new ArrayList<>();
    // public List<String> wordBreak(String s, List<String> wordDict) {
    // dfs("", s, wordDict);
    // return ans;
    // }
    // public void dfs(String res, String s, List<String> wordDict) {
    // if (s.isEmpty()) {
    // ans.add(res);
    // return;
    // }
    // for (int i = 0; i < wordDict.size(); i++) {
    // String tmp = wordDict.get(i);
    // int index = s.indexOf(tmp);
    // if (index == 0) {
    // List<String> nwd = new ArrayList<>();
    // nwd.addAll(wordDict);
    // StringBuilder nres = new StringBuilder(res);
    // nres.append(tmp);
    // if (!tmp.equals(s)) {
    // nres.append(" ");
    // }
    // dfs(nres.toString(), String.copyValueOf(s.toCharArray(), tmp.length(),
    // s.length() - tmp.length()), nwd);
    // }
    // }
    // return;
    // }

    // method 1
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // map相当与备忘录，存放了一些已经计算好的组合值，防止重复计算

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
            // String in = sc.nextLine();
            // in = in.replaceAll("\"", "");
            List<String> dictionary = Arrays.asList(sc.nextLine().replaceAll("\"", "").split(","));
            List<String> ans = s.wordBreak(target, dictionary);
            for (String var : ans) {
                System.out.println(var);
            }
            ans.clear();
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