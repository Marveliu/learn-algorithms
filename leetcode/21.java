import java.util.*;
// 131. Palindrome Partitioning
// 非递归动态规划实现
// Map<Integer, List<List<String>>> 字符串sub(0,n)的所有组合，
// 遍历，判断是否出现了回文情况，是则增加情况。
public class Solution {

    public List<List<String>> partition(String s) {
        if (s.length() == 0)
            return null;
        Map<Integer, List<List<String>>> ans = new HashMap<>();
        List<List<String>> init = new ArrayList<>();
        List<String> ls = new ArrayList();
        ls.add(s.substring(0, 1));
        init.add(ls);
        ans.put(0, init);

        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    List<List<String>> tmp = new ArrayList<>();
                    List<List<String>> lls = ans.get(j - 1);
                    if (lls != null) {
                        for (List<String> var : lls) {
                            List<String> copy = new ArrayList<>();
                            copy.addAll(var);
                            copy.add(s.substring(j, i + 1));
                            tmp.add(copy);
                        }
                    } else {
                        List<String> sub = new ArrayList<>();
                        sub.add(s.substring(j, i + 1));
                        tmp.add(sub);
                    }
                    if (ans.containsKey(i)) {
                        ans.get(i).addAll(tmp);
                    } else {
                        ans.put(i, tmp);
                    }
                }
            }
        }
        return ans.get(s.length() - 1);
    }

    public static boolean isPalindrome(String s) {
        int middle = s.length() / 2;
        for (int i = 0; i <= middle; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            List<List<String>> ans = s.partition(in);
            for (List<String> var : ans) {
                System.out.println(Arrays.toString((var.toArray())));
            }
        }
    }
}