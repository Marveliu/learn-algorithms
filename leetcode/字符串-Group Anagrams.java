import java.util.*;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams
 * 
 */
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
