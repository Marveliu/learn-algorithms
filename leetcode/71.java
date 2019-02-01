import java.util.*;

/**
 * 77. Combinations
 * 思路：dfs+回溯
 * 时间复杂度：o(n^2)
 * 空间复杂度：o(n)
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    // List<List<Integer>> ans = null;

    // public List<List<Integer>> combine(int n, int k) {
    // if (k > n)
    // return null;
    // ans = new ArrayList<>();
    // dfs(1, n, k, new ArrayList<>());
    // return ans;
    // }

    // public void dfs(int s, int n, int k, List<Integer> list) {
    // if (s > n + 1 || k < 0)
    // return;
    // if (k == 0) {
    // ans.add(list);
    // return;
    // }

    // dfs(s + 1, n, k, new ArrayList<>(list));

    // List<Integer> tmp = new ArrayList<>(list);
    // tmp.add(s);
    // dfs(s + 1, n, k - 1, tmp);
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            sc.nextLine();
            int k = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> ans = s.combine(n, k);
            for (List<Integer> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}