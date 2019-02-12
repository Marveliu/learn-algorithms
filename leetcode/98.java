import java.util.*;

// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/solution/
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    // Map<String, char[]> map = null;

    // public List<List<String>> groupAnagrams(String[] strs) {
    // map = new HashMap<>();
    // List<List<String>> ans = new ArrayList<>();
    // for (String var : strs) {
    // check(ans, var);
    // }
    // return ans;
    // }

    // public void check(List<List<String>> ans, String var) {
    // for (List<String> s : ans) {
    // if (isAnagrams(s.get(0), var)) {
    // s.add(var);
    // return;
    // }
    // }
    // List<String> ns = new ArrayList<>();
    // ns.add(var);
    // ans.add(ns);
    // char[] ac = var.toCharArray();
    // Arrays.sort(ac);
    // map.put(var, ac);
    // return;
    // }

    // public boolean isAnagrams(String a, String b) {
    // if (a.length() != b.length())
    // return false;
    // char[] ac = map.get(a);
    // char[] bc = b.toCharArray();
    // Arrays.sort(bc);
    // for (int i = 0; i < ac.length; i++) {
    // if (ac[i] != bc[i])
    // return false;
    // }
    // return true;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String[] strs = StringUtil.nextLineFilter(sc).split(",");
            for (List<String> var : s.groupAnagrams(strs)) {
                System.out.println(Arrays.toString(var.toArray()));
            }

        }
    }
}
