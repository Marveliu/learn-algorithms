import java.util.*;

// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
// dfs
public class Solution {

    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        ArrayList<Character> cs = new ArrayList<Character>();
        for (Character c : str.toCharArray()) {
            cs.add(c);
        }
        String s = new String();
        dfs(cs, s);
        return res;
    }

    public void dfs(ArrayList<Character> arr, String s) {
        if (arr.size() == 0 && !s.equals("")) {
            if (!res.contains(s))
                res.add(s);
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Character> tmp = new ArrayList<>();
            for (Character var : arr) {
                tmp.add(var);
            }
            StringBuilder n = new StringBuilder(s);
            tmp.remove(i);
            dfs(tmp, n.append(arr.get(i)).toString());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input>>>");
        ArrayList<String> as = s.Permutation(sc.nextLine());
        for (String var : as) {
            System.out.println(var);
        }

        // test...
    }
}

// aa
// abc